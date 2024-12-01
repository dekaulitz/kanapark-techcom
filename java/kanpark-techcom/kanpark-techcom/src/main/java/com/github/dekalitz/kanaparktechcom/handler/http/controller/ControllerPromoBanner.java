package com.github.dekalitz.kanaparktechcom.handler.http.controller;

import com.github.dekalitz.kanaparktechcom.application.dto.param.ParamBannerPromoGetAll;
import com.github.dekalitz.kanaparktechcom.application.dto.param.ParamProductGetAll;
import com.github.dekalitz.kanaparktechcom.application.dto.Response;
import com.github.dekalitz.kanaparktechcom.application.exception.ApplicationException;
import com.github.dekalitz.kanaparktechcom.application.usecase.product.UseCaseGetAllProduct;
import com.github.dekalitz.kanaparktechcom.application.usecase.promobanner.UseCaseGetAllBannerPromo;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelProduct;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelPromoBanner;
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
@RequestMapping("/api/v1/promo-banners")
@Slf4j
public class ControllerPromoBanner extends BaseApiController {

  private final UseCaseGetAllBannerPromo useCaseGetAllBannerPromo;

  @Autowired
  public ControllerPromoBanner(HttpServletRequest request,
      UseCaseGetAllBannerPromo useCaseGetAllBannerPromo) {
    super(request);
    this.useCaseGetAllBannerPromo = useCaseGetAllBannerPromo;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<List<ModelPromoBanner>>> getAll(
      @Valid @ModelAttribute ParamBannerPromoGetAll param) throws ApplicationException {
    return ResponseEntity.ok(useCaseGetAllBannerPromo.execute(param));
  }
}
