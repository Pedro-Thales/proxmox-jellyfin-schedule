package com.pedrovisk.proxmox.service;


import com.pedrovisk.proxmox.api.JellyfinApi;
import com.pedrovisk.proxmox.configuration.JellyfinProperties;
import com.pedrovisk.proxmox.models.jellyfin.MessageRequest;
import com.pedrovisk.proxmox.models.jellyfin.PlayState;
import com.pedrovisk.proxmox.models.jellyfin.Session;
import com.pedrovisk.proxmox.repository.SessionsInMemoryRepository;
import com.pedrovisk.proxmox.utils.MeasureRunTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class JellyfinService {
    public static final String SHUTDOWN_MESSAGE = "Server will shutdown play something if you don't want it to shutdown!!";

    @Autowired
    JellyfinApi jellyfinApi;

    @Autowired
    SessionsInMemoryRepository sessionRepository;

    @Autowired
    private JellyfinProperties jellyfinProperties;

    @MeasureRunTime
    public boolean canShutdown() {

        var sessions = jellyfinApi.getAllSessions();
        List<Boolean> sessionsResults = new ArrayList<>();

        for (Session session : sessions){

            log.info("Checking session of user: {}", session.getUserName());
            var savedSession = sessionRepository.get(session.getId());
            if (savedSession == null) {
                sessionRepository.insert(session.getId(), new Date());
                sessionsResults.add(false);
                continue;
            }

            var expired = savedSession.toInstant().isBefore(
                    Instant.now().minus(jellyfinProperties.pausedSessionTimeout(), ChronoUnit.MINUTES));

            if (isSessionStopped(session.playState)) {
                log.info("Session: {} IS STOPPED! Is it expired? {}", session.getId(), expired);
                sendShutdownMessage(session);
                sessionsResults.add(expired);
            }

            if (isSessionPlaying(session.playState)) {
                log.info("Session: {} IS PLAYING", session.getId());
                sessionsResults.add(false);
                sessionRepository.remove(session.getId());
            }

            if (isSessionPaused(session.playState)) {
                log.info("Session: {} IS PAUSED! Is it expired? {}", session.getId(), expired);
                sendShutdownMessage(session);
                sessionsResults.add(expired);
            }

        }

        sessions.clear();

        return !sessionsResults.contains(false);

    }

    private void sendShutdownMessage(Session session) {
        jellyfinApi.sendMessage(session.getId(), MessageRequest.builder()
                .text(SHUTDOWN_MESSAGE)
                .timeoutMs(10000).build());
    }

    public boolean isSessionPlaying(PlayState playState) {
        return playState.mediaSourceId != null && playState.playMethod != null && !playState.isPaused;
    }

    public boolean isSessionStopped(PlayState playState) {
        return playState.mediaSourceId == null && playState.playMethod == null;
    }

    public boolean isSessionPaused(PlayState playState) {
        return playState.isPaused && jellyfinProperties.disconnectPausedSession();
    }

}
