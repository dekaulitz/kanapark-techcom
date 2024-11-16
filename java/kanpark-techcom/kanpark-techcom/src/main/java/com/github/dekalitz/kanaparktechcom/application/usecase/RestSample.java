package com.github.dekalitz.kanaparktechcom.application.usecase;

import com.github.dekalitz.kanaparktechcom.application.exception.ApplicationException;
import com.github.dekalitz.kanaparktechcom.domain.repository.rest.Something;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.utils.RestResult;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

public class RestSample implements UseCase<String, String> {

  private final Something something;

  public RestSample(Something something) {
    this.something = something;
  }

  @Override
  public String execute(String dto) throws ApplicationException {
    RestResult<String> result = this.something.getData()
        .onErrorResume(Mono::error)
        .block();
    assert result != null;
    if (null != result.getApplicationException()) {
      throw result.getApplicationException();
    }
    return result.getResponse();
  }
}
