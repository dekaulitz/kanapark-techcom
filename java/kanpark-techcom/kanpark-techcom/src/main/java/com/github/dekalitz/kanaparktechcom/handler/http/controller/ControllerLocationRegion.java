package com.github.dekalitz.kanaparktechcom.handler.http.controller;

import com.github.dekalitz.kanaparktechcom.application.dto.Response;
import com.github.dekalitz.kanaparktechcom.application.dto.param.ParamBannerPromoGetAll;
import com.github.dekalitz.kanaparktechcom.application.dto.param.ParamLocationRegionGetAll;
import com.github.dekalitz.kanaparktechcom.application.exception.ApplicationException;
import com.github.dekalitz.kanaparktechcom.application.usecase.location.UseCaseGetAllLocationRegion;
import com.github.dekalitz.kanaparktechcom.application.usecase.promobanner.UseCaseGetAllBannerPromo;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelPromoBanner;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelRegion;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/location/regions")
@Slf4j
public class ControllerLocationRegion extends BaseApiController {

  private final UseCaseGetAllLocationRegion useCaseGetAllLocationRegion;

  @Autowired
  public ControllerLocationRegion(HttpServletRequest request,
      UseCaseGetAllLocationRegion useCaseGetAllLocationRegion) {
    super(request);
    this.useCaseGetAllLocationRegion = useCaseGetAllLocationRegion;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<List<ModelRegion>>> getAll(
      @Valid @ModelAttribute ParamLocationRegionGetAll param) throws ApplicationException {

    return ResponseEntity.ok(useCaseGetAllLocationRegion.execute(param));
  }
}
