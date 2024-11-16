package com.github.dekalitz.kanaparktechcom.domain.repository.rest;

import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.utils.RestResult;
import reactor.core.publisher.Mono;

public interface Something {

  Mono<RestResult<String>> getData();

}
