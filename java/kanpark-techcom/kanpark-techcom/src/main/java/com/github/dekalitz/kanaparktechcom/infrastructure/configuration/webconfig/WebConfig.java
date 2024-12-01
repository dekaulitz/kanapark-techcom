package com.github.dekalitz.kanaparktechcom.infrastructure.configuration.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // Semua metode HTTP
        .allowedHeaders("*") // Izinkan semua header
//        .allowCredentials(true) // Mengizinkan pengiriman kredensial seperti cookies
        .maxAge(3600); // Maksimal cache CORS selama 1 jam
  }
}