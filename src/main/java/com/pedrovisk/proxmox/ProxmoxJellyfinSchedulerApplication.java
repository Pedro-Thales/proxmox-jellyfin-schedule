package com.pedrovisk.proxmox;

import com.pedrovisk.proxmox.api.JellyfinApi;
import com.pedrovisk.proxmox.api.ProxmoxApi;
import com.pedrovisk.proxmox.configuration.JellyfinProperties;
import com.pedrovisk.proxmox.configuration.ProxmoxProperties;
import feign.Logger;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableConfigurationProperties({JellyfinProperties.class, ProxmoxProperties.class})
@RegisterReflectionForBinding({JellyfinApi.class, ProxmoxApi.class})
public class ProxmoxJellyfinSchedulerApplication {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProxmoxJellyfinSchedulerApplication.class, args);
    }

}
