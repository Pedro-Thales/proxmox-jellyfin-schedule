package com.pedrovisk.proxmox.service;


import com.pedrovisk.proxmox.api.ProxmoxApi;
import com.pedrovisk.proxmox.models.proxmox.CommandRequest;
import com.pedrovisk.proxmox.utils.MeasureRunTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProxmoxService {

    @Autowired
    ProxmoxApi proxmoxApi;

    @MeasureRunTime
    public void shutdownNode() {

        try {
            proxmoxApi.shutdownNode(new CommandRequest("h"));
        } catch (Exception e) {
            System.out.println("Exception = " + e);
        }

    }

}
