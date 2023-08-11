package com.pedrovisk.proxmox.api;

import com.pedrovisk.proxmox.configuration.JellyfinProperties;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class JellyfinRequestInterceptor implements RequestInterceptor {

    @Autowired
    private JellyfinProperties jellyfinProperties;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization",
                "MediaBrowser Token=\"" + jellyfinProperties.authToken() + "\"");
    }
}

