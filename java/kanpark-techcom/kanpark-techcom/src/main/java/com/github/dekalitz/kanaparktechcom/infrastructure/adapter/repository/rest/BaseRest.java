package com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.rest;

import lombok.Getter;
import org.springframework.web.reactive.function.client.WebClient;

@Getter
public class BaseRest {

  private final WebClient webClient;

  public BaseRest(WebClient webClient) {
    this.webClient = webClient;
  }
}
