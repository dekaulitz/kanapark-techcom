package com.github.dekalitz.kanaparktechcom.handler.http.advice;

import com.github.dekalitz.kanaparktechcom.application.dto.Response;
import com.github.dekalitz.kanaparktechcom.application.exception.ApplicationException;
import com.github.dekalitz.kanaparktechcom.application.records.ErrorCode;
import com.github.dekalitz.kanaparktechcom.infrastructure.configuration.security.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Response<Object>> handleValidationErrors(
      MethodArgumentNotValidException ex) {
    List<String> errors = ex.getBindingResult().getFieldErrors().stream()
        .map(FieldError::getDefaultMessage).collect(Collectors.toList());
    var errCode = ErrorCode.errorOnRequiredField(errors);
    return getResponseResponseEntity(errCode);

  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Response<Object>> handleIllegalArgumentException(
      MethodArgumentNotValidException ex) {
    List<String> errors = ex.getBindingResult().getFieldErrors().stream()
        .map(FieldError::getDefaultMessage).collect(Collectors.toList());
    var errCode = ErrorCode.errorOnRequiredField(errors);
    return getResponseResponseEntity(errCode);

  }

  @ExceptionHandler(ApplicationException.class)
  public ResponseEntity<Response<Object>> handleApplicationException(ApplicationException ex) {
    var errCode = ex.getErrorCode();
    if (errCode == null) {
      errCode = ErrorCode.generalError(ex.getMessage());
    }
    return getResponseResponseEntity(errCode);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Response<Object>> handleApplicationException(Exception ex) {
    log.error(ex.getMessage(), ex);
    return getResponseResponseEntity(ErrorCode.errorOnUnhandledException());
  }

  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<Response<Object>> handleApplicationException(UnauthorizedException ex) {
    var errCode = ex.getErrorCode();
    return getResponseResponseEntity(errCode);
  }

  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity<Response<Object>> handleAccessDeniedException(AuthenticationException ex) {
    var errCode = ErrorCode.errorOnForbiddenRequest(ex.getMessage());
    return getResponseResponseEntity(errCode);
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<Response<Object>> handlingInvalidMethod(
      HttpRequestMethodNotSupportedException ex) {
    var errCode = ErrorCode.errorOnInvalidMethod(ex.getMessage());
    var result = new Response<>(new Response.MetaResponse("failed"), null,
        new Response.ErrorResponse(errCode.statusCode(), errCode.message()));
    return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
  }

  private ResponseEntity<Response<Object>> getResponseResponseEntity(ErrorCode errCode) {
    var result = new Response<>(new Response.MetaResponse("failed"), null,
        new Response.ErrorResponse(errCode.statusCode(), errCode.message()));
    var httpCode = HttpStatus.resolve(errCode.httpCode());
    return new ResponseEntity<>(result, new HttpHeaders(),
        httpCode != null ? httpCode : HttpStatus.INTERNAL_SERVER_ERROR);
  }
}

