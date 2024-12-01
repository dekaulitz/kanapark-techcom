package com.github.dekalitz.kanaparktechcom.application.usecase.promobanner;

import com.github.dekalitz.kanaparktechcom.application.dto.param.ParamBannerPromoGetAll;
import com.github.dekalitz.kanaparktechcom.application.dto.Response;
import com.github.dekalitz.kanaparktechcom.application.exception.ApplicationException;
import com.github.dekalitz.kanaparktechcom.application.usecase.BaseCase;
import com.github.dekalitz.kanaparktechcom.application.usecase.UseCase;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelPromoBanner;
import com.github.dekalitz.kanaparktechcom.domain.service.servicepromobanner.ServicePromoBanner;
import java.util.List;

public class UseCaseGetAllBannerPromo extends BaseCase<List<ModelPromoBanner>> implements
    UseCase<Response<List<ModelPromoBanner>>, ParamBannerPromoGetAll> {

  private final ServicePromoBanner servicePromoBanner;

  public UseCaseGetAllBannerPromo(ServicePromoBanner servicePromoBanner) {
    this.servicePromoBanner = servicePromoBanner;
  }

  @Override
  public Response<List<ModelPromoBanner>> execute(ParamBannerPromoGetAll dto)
      throws ApplicationException {
    return ok(servicePromoBanner.findAll().stream().limit(dto.getLimit()).toList());
  }
}
