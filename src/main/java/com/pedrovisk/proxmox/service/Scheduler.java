package com.pedrovisk.proxmox.service;

import com.pedrovisk.proxmox.configuration.ProxmoxProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
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
            System.out.println("Shutting down");
            if (proxmoxProperties.apiEnableShutdown()) {
                System.out.println("Node shutdown is enabled");
                proxmoxService.shutdownNode();
                return;
            }
            System.out.println("Node shutdown is disabled");

        }

        System.out.println("Cannot shut down");

    }
}
