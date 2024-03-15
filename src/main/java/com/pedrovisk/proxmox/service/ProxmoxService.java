package com.pedrovisk.proxmox.service;


import com.pedrovisk.proxmox.api.ProxmoxApi;
import com.pedrovisk.proxmox.models.proxmox.CommandRequest;
import com.pedrovisk.proxmox.utils.MeasureRunTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProxmoxService {

    @Autowired
    ProxmoxApi proxmoxApi;

    @MeasureRunTime
    public void shutdownNode() {

        try {
            proxmoxApi.shutdownNode(new CommandRequest("shutdown"));
        } catch (Exception e) {
            log.error("Exception = " + e);
        }

    }

}
