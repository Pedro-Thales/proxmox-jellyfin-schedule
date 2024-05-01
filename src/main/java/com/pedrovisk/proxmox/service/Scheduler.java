package com.pedrovisk.proxmox.service;

import com.pedrovisk.proxmox.configuration.ProxmoxProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Scheduler {

    @Autowired
    JellyfinService jellyfinService;

    @Autowired
    ProxmoxService proxmoxService;

    @Autowired
    ProxmoxProperties proxmoxProperties;

    @Scheduled(cron = "${cron.expression}")
    public void shutdownJob() {

        if (jellyfinService.canShutdown()) {
            log.info("Shutting down");
            if (proxmoxProperties.apiEnableShutdown()) {
                log.info("Node shutdown is enabled");
                proxmoxService.shutdownNode();
                return;
            }
            log.warn("Node shutdown is disabled");

        }

        log.info("Cannot shut down");

    }
}
