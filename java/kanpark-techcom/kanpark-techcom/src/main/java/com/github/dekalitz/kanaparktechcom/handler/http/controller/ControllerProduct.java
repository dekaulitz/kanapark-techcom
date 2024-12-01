package com.github.dekalitz.kanaparktechcom.handler.http.controller;

import com.github.dekalitz.kanaparktechcom.application.dto.param.ParamProductGetAll;
import com.github.dekalitz.kanaparktechcom.application.dto.Response;
import com.github.dekalitz.kanaparktechcom.application.exception.ApplicationException;
import com.github.dekalitz.kanaparktechcom.application.usecase.product.UseCaseGetAllProduct;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelProduct;
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
@RequestMapping("/api/v1/products")
@Slf4j
public class ControllerProduct extends BaseApiController {

  private final UseCaseGetAllProduct useCaseGetAllProduct;

  @Autowired
  public ControllerProduct(HttpServletRequest request, UseCaseGetAllProduct useCaseGetAllProduct) {
    super(request);
    this.useCaseGetAllProduct = useCaseGetAllProduct;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<List<ModelProduct>>> getAll(
     @Valid @ModelAttribute ParamProductGetAll param) throws ApplicationException {
    return ResponseEntity.ok(useCaseGetAllProduct.execute(param));
  }
}
