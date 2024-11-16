package com.github.dekalitz.kanaparktechcom.infrastructure.configuration.application;

import com.github.dekalitz.kanaparktechcom.domain.repository.rest.Something;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.rest.SomethingApi;
import com.github.dekalitz.kanaparktechcom.infrastructure.configuration.webclient.WebClientConfig;
import com.github.dekalitz.kanaparktechcom.infrastructure.configuration.webclient.WebClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfiguration extends WebClientConfig {

  private final WebClientProperties webClientProperties;

  @Autowired
  public RestConfiguration(WebClientProperties webClientProperties) {
    this.webClientProperties = webClientProperties;
  }

  @Bean
  public Something something() {
    return new SomethingApi(webClient(webClientProperties).build());
  }
}
