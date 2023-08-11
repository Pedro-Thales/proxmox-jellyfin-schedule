package com.pedrovisk.proxmox.api;

import com.pedrovisk.proxmox.CustomFeignConfiguration;
import com.pedrovisk.proxmox.models.jellyfin.MessageRequest;
import com.pedrovisk.proxmox.models.jellyfin.Session;
import com.pedrovisk.proxmox.utils.MeasureRunTime;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "jellyfin", url = "${jellyfin.api-url}", configuration = {JellyfinRequestInterceptor.class, CustomFeignConfiguration.class})
public interface JellyfinApi {

    @MeasureRunTime
    @RequestMapping(method = RequestMethod.GET, value = "Sessions", consumes = "application/json",
            produces = "application/json")
    List<Session> getAllSessions();

    @RequestMapping(method = RequestMethod.POST, value = "Sessions/{sessionId}/Message",
            consumes = "application/json", produces = "application/json")
    String sendMessage(@PathVariable String sessionId, @RequestBody MessageRequest message);

}
