package com.github.dekalitz.kanaparktechcom.domain.service.servicepromobanner;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelPromoBanner;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.RepositoryBase;
import com.github.dekalitz.kanaparktechcom.domain.service.base.BaseServiceImpl;

public class ServicePromoBannerImpl extends BaseServiceImpl<ModelPromoBanner> implements ServicePromoBanner {

  public ServicePromoBannerImpl(
      RepositoryBase<ModelPromoBanner> repository) {
    super(repository);
  }
}
