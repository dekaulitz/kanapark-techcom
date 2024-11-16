package com.github.dekalitz.kanaparktechcom.infrastructure.adapter.utils;

import com.github.dekalitz.kanaparktechcom.application.exception.ApplicationException;
import com.github.dekalitz.kanaparktechcom.application.records.ErrorCode;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

@Slf4j
public class RestUtils<Request, Response> {

  private final String url;
  protected final Class<Response> responseClass;
  private final WebClient webClient;
  private Map<String, String> headers;
  private Map<String, String> queryParams;
  private boolean async;

  public RestUtils(WebClient webClient, String url, Class<Response> responseClass, boolean async) {
    this.webClient = webClient;
    this.url = url;
    this.responseClass = responseClass;
    this.async = async;
  }

  public RestUtils<Request, Response> setHeaders(Map<String, String> headerMap) {
    this.headers = headerMap;
    return this;
  }

  public RestUtils<Request, Response> setQueryParam(Map<String, String> queryParams) {
    this.queryParams = queryParams;
    return this;
  }

  public Mono<Response> post(Request request) {
    return this.webClient.post()
        .uri(uriBuilder -> {
          UriBuilder uri = uriBuilder.path(this.url);
          if (null != this.queryParams && !this.queryParams.isEmpty()) {
            this.queryParams.forEach(uri::queryParam);
          }
          return uri.build();
        })
        .bodyValue(request)
        .headers(httpHeaders -> {
          if (null != headers && !headers.isEmpty()) {
            this.headers.forEach(httpHeaders::add);
          }
        })
        .retrieve()
        .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
            .flatMap(response -> {
              log.info("request to url{} payload:{},headers:{} httpStatus:{} response:{}", this.url,
                  request, this.headers,
                  clientResponse.statusCode(), response);
              return Mono.error(new ApplicationException(
                  ErrorCode.outboundException()));
            }))
        .bodyToMono(this.responseClass)
        .doOnNext(response -> {
          log.info("request to url{}, payload:{},headers:{}, response:{}", this.url,
              request, this.headers, response);
        });
  }

  public Mono<RestResult<Response>> get() {
    return this.webClient.get()
        .uri(uriBuilder -> {
          UriBuilder uri = uriBuilder.path(this.url);
          if (null != this.queryParams && !this.queryParams.isEmpty()) {
            this.queryParams.forEach(uri::queryParam);
          }
          return uri.build();
        })
        .headers(httpHeaders -> {
          if (null != headers && !headers.isEmpty()) {
            this.headers.forEach(httpHeaders::add);
          }
        })
        .retrieve()
        .bodyToMono(this.responseClass)
        .flatMap(response -> Mono.just(new RestResult<>(response, null, null)))
        .onErrorResume(WebClientResponseException.class, ex -> {
          if (this.async) {
            return Mono.error(new ApplicationException(
                ErrorCode.outboundException()));
          }
          return Mono.just(new RestResult<>(null, ex.getMessage(),
              new ApplicationException(ErrorCode.outboundException())));
        });
  }

  public Mono<Response> put(Request request) {
    return this.webClient.put()
        .uri(uriBuilder -> {
          UriBuilder uri = uriBuilder.path(this.url);
          if (null != this.queryParams && !this.queryParams.isEmpty()) {
            this.queryParams.forEach(uri::queryParam);
          }
          return uri.build();
        })
        .headers(httpHeaders -> {
          if (null != headers && !headers.isEmpty()) {
            this.headers.forEach(httpHeaders::add);
          }
        })
        .bodyValue(request)
        .retrieve()
        .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
            .flatMap(response -> {
              log.info("request to url{} payload:{},headers:{} httpStatus:{} response:{}", this.url,
                  request, this.headers,
                  clientResponse.statusCode(), response);
              return Mono.error(new ApplicationException(
                  ErrorCode.outboundException()));
            }))
        .bodyToMono(this.responseClass)
        .doOnNext(response -> {
          log.info("request to url{}, payload:{},headers:{}, response:{}", this.url,
              request, this.headers, response);
        });
  }

  public Mono<Response> delete() {
    return this.webClient.put()
        .uri(uriBuilder -> {
          UriBuilder uri = uriBuilder.path(this.url);
          if (null != this.queryParams && !this.queryParams.isEmpty()) {
            this.queryParams.forEach(uri::queryParam);
          }
          return uri.build();
        })
        .headers(httpHeaders -> {
          if (null != headers && !headers.isEmpty()) {
            this.headers.forEach(httpHeaders::add);
          }
        })
        .retrieve()
        .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
            .flatMap(response -> {
              log.info("request to url{},headers:{} httpStatus:{} response:{}", this.url,
                  this.headers, clientResponse.statusCode(), response);
              return Mono.error(new ApplicationException(
                  ErrorCode.outboundException()));
            }))
        .bodyToMono(this.responseClass)
        .doOnNext(response -> {
          log.info("request to url{},headers:{}, response:{}", this.url, this.headers, response);
        });
  }

}
