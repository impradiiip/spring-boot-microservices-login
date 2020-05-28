package com.tom.mobileapp.securityauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SecurityAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityAuthServerApplication.class, args);
	}

}
