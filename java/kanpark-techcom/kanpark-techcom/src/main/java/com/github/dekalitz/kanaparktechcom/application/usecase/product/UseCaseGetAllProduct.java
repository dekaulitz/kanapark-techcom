package com.github.dekalitz.kanaparktechcom.application.usecase.product;

import com.github.dekalitz.kanaparktechcom.application.dto.param.ParamProductGetAll;
import com.github.dekalitz.kanaparktechcom.application.dto.Response;
import com.github.dekalitz.kanaparktechcom.application.exception.ApplicationException;
import com.github.dekalitz.kanaparktechcom.application.usecase.BaseCase;
import com.github.dekalitz.kanaparktechcom.application.usecase.UseCase;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelProduct;
import com.github.dekalitz.kanaparktechcom.domain.service.serviceproduct.ServiceProduct;
import java.util.List;

public class UseCaseGetAllProduct extends BaseCase<List<ModelProduct>> implements
    UseCase<Response<List<ModelProduct>>, ParamProductGetAll> {

  private final ServiceProduct serviceProduct;

  public UseCaseGetAllProduct(ServiceProduct serviceProduct) {
    this.serviceProduct = serviceProduct;
  }


  @Override
  public Response<List<ModelProduct>> execute(ParamProductGetAll param)
      throws ApplicationException {
    return ok(serviceProduct.findAll().stream().limit(param.getLimit()).toList());
  }
}
