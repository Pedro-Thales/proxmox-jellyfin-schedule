package com.pedrovisk.proxmox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Autowired
    JellyfinService jellyfinService;

    @Autowired
    ProxmoxService proxmoxService;

    @Scheduled(cron = "${cron.expression}")
    public void shutdownJob() {

        if (jellyfinService.canShutdown()) {
            System.out.println("Shutting down");
            proxmoxService.shutdownNode();
            return;
        }

        System.out.println("Cannot shut down");

    }
}
