package com.github.dekalitz.kanaparktechcom.application.exception;

import com.github.dekalitz.kanaparktechcom.application.records.ErrorCode;
import java.io.Serial;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class ApplicationException extends Exception implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  private ErrorCode errorCode;
  private String detailMessage;

  public ApplicationException() {
    super();
  }

  public ApplicationException(ErrorCode message) {
    super(message.message());
    this.errorCode = message;
  }

  public ApplicationException(String message) {
    super(message);

  }

  public ApplicationException(ErrorCode message, String detailMessage) {
    super(detailMessage);
    this.errorCode = message;
    this.detailMessage = detailMessage;
  }

  public ApplicationException(ErrorCode message, String detailMessage, Throwable cause) {
    super(detailMessage, cause);
    this.errorCode = message;
    this.detailMessage = detailMessage;
  }
}
