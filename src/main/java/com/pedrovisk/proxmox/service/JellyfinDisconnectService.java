package com.pedrovisk.proxmox.service;


import com.pedrovisk.proxmox.api.JellyfinApi;
import com.pedrovisk.proxmox.configuration.JellyfinProperties;
import com.pedrovisk.proxmox.models.jellyfin.MessageRequest;
import com.pedrovisk.proxmox.models.jellyfin.PlayState;
import com.pedrovisk.proxmox.repository.SessionsInMemoryRepository;
import com.pedrovisk.proxmox.utils.MeasureRunTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JellyfinDisconnectService {
    public static final String SHUTDOWN_MESSAGE = "Server will shutdown in minutes play something if you don't want it to shutdown!!";

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

        sessions.forEach(session -> {
            System.out.println("Checking session of user: " + session.getUserName());

            if (isSessionStopped(session.playState)) {
                System.out.println("Session: " + session.getId() + "IS STOPPED");
                jellyfinApi.sendMessage(session.getId(), MessageRequest.builder()
                        .text(SHUTDOWN_MESSAGE)
                        .timeoutMs(10000).build());
                sessionsResults.add(true);

            }
            if (isSessionPlaying(session.playState)) {
                System.out.println("Session: " + session.getId() + "IS PLAYING");
                sessionsResults.add(false);
                sessionRepository.remove(session.getId());
            }

            if (isSessionPaused(session.playState)) {

                System.out.println("Session: " + session.getId() + "IS PAUSED");
                jellyfinApi.sendMessage(session.getId(), MessageRequest.builder()
                        .text(SHUTDOWN_MESSAGE)
                        .timeoutMs(10000).build());
                var savedSession = sessionRepository.get(session.getId());
                if (savedSession == null) {
                    sessionRepository.insert(session.getId(), new Date());
                    sessionsResults.add(false);
                } else {
                    var expired = savedSession.toInstant().isBefore(
                            Instant.now().minus(jellyfinProperties.pausedSessionTimeout(), ChronoUnit.MINUTES));
                    System.out.println("Expired? " + expired);
                    sessionsResults.add(expired);

                }
            }

        });

        sessions.clear();

        return !sessionsResults.contains(false);

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
