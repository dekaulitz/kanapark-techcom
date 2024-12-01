package com.github.dekalitz.kanaparktechcom.handler.http.controller;

import com.github.dekalitz.kanaparktechcom.application.dto.RequestInfo;
import com.github.dekalitz.kanaparktechcom.application.dto.Response;
import com.github.dekalitz.kanaparktechcom.application.dto.ResponseUserDto;
import com.github.dekalitz.kanaparktechcom.application.records.ErrorCode;
import com.github.dekalitz.kanaparktechcom.infrastructure.configuration.security.UserAuthToken;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseApiController {

  private final HttpServletRequest request;
  private SecurityContextHolder securityContextHolder;

  @Autowired
  public BaseApiController(HttpServletRequest request) {
    this.request = request;
  }

  public RequestInfo getRequestInfo() {
    return (RequestInfo) request.getAttribute("requestInfo");
  }

    public UserAuthToken getUserAuthTokenInfo(){
        return (UserAuthToken) SecurityContextHolder.getContext().getAuthentication();
    }
}
