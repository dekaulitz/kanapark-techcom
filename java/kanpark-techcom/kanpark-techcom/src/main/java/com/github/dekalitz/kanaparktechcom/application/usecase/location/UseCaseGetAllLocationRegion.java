package com.github.dekalitz.kanaparktechcom.application.usecase.location;

import com.github.dekalitz.kanaparktechcom.application.dto.Response;
import com.github.dekalitz.kanaparktechcom.application.dto.param.ParamLocationRegionGetAll;
import com.github.dekalitz.kanaparktechcom.application.dto.param.ParamProductGetAll;
import com.github.dekalitz.kanaparktechcom.application.exception.ApplicationException;
import com.github.dekalitz.kanaparktechcom.application.usecase.BaseCase;
import com.github.dekalitz.kanaparktechcom.application.usecase.UseCase;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelProduct;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelRegion;
import com.github.dekalitz.kanaparktechcom.domain.service.location.ServiceRegion;
import com.github.dekalitz.kanaparktechcom.domain.service.serviceproduct.ServiceProduct;
import java.util.List;

public class UseCaseGetAllLocationRegion extends BaseCase<List<ModelRegion>> implements
    UseCase<Response<List<ModelRegion>>, ParamLocationRegionGetAll> {

  private final ServiceRegion serviceRegion;

  public UseCaseGetAllLocationRegion(ServiceRegion serviceRegion) {
    this.serviceRegion = serviceRegion;
  }


  @Override
  public Response<List<ModelRegion>> execute(ParamLocationRegionGetAll param)
      throws ApplicationException {
    return ok(serviceRegion.findAll().stream().limit(param.getLimit()).toList());
  }
}
