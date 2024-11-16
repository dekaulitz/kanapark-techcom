package com.github.dekalitz.kanaparktechcom.infrastructure.configuration.logger;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogModel {

  private LocalDateTime timestamp;
  private String level;
  private String metadata;
  private Object message;
  private String requestId;
}
