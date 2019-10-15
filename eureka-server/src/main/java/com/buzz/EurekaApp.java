package com.buzz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication

/**
 * eureka注册中心
 */
public class EurekaApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaApp.class).web(true).run(args);
    }
}
