package com.pedrovisk.proxmox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Autowired
    JellyfinDisconnectService jellyfinDisconnectService;

    @Scheduled(cron = "${cron.expression}")
    public void shutdownJob() {

        if (jellyfinDisconnectService.canShutdown()) {
            System.out.println("Shutting down");
            return;
        }

        System.out.println("Cannot shut down");

    }
}
