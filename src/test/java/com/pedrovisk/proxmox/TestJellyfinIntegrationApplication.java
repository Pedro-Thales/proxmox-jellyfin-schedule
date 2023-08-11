package com.pedrovisk.proxmox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestJellyfinIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProxmoxJellyfinSchedulerApplication::main).with(TestJellyfinIntegrationApplication.class).run(args);
	}

}
