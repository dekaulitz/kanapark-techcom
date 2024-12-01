package com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.rest;

import com.github.dekalitz.kanaparktechcom.domain.repository.rest.Something;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.utils.RestResult;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.utils.RestUtils;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class SomethingApi extends BaseRest implements Something {

  private final RestUtils<String, String> createUserRestConfig;

  public SomethingApi(WebClient webClient) {
    super(webClient);
    this.createUserRestConfig = new RestUtils<>(
        webClient, "/product",
        String.class,
        false
    );
  }

  @Override
  public Mono<RestResult<String>> getData() {
    Map<String, String> queryparams = new HashMap<>();
    return this.createUserRestConfig
        .setQueryParam(queryparams)
        .get();
  }
}
