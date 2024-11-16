package com.github.dekalitz.kanaparktechcom.infrastructure.adapter.utils;

import com.github.dekalitz.kanaparktechcom.application.exception.ApplicationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResult<T> {

  private T response;
  private String responseString;
  private ApplicationException applicationException;
}
