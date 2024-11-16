package com.github.dekalitz.kanaparktechcom.infrastructure.configuration.webclient;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WebClientProperties {

  private static final int DEFAULT_MAX_CONNECTIONS = 2000;
  private static final int DEFAULT_CONNECTION_TIMEOUT = 5000;
  private static final int DEFAULT_READ_WRITE_TIMEOUT = 10000;
  private int maxConnections = DEFAULT_MAX_CONNECTIONS;
  private int connectionTimeoutInMillis = DEFAULT_CONNECTION_TIMEOUT;
  private int readTimeoutInMillis = DEFAULT_READ_WRITE_TIMEOUT;
  private int writeTimeoutInMillis = DEFAULT_READ_WRITE_TIMEOUT;
  private @NotBlank String baseUrl = "https://dummyjson.com";

}
