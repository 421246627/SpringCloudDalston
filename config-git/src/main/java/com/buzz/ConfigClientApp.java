package com.buzz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigClientApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClientApp.class).web(true).run(args);
    }
}
