package com.pedrovisk.proxmox.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("jellyfin")
public record JellyfinProperties(String apiUrl, String authToken, boolean disconnectPausedSession,
                                 Integer pausedSessionTimeout) {
}
