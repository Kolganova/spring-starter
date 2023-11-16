package com.kolganova.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("web")
@Configuration
public class WebConfiguration {
    public WebConfiguration() {
    }
}
