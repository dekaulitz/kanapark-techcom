package com.github.dekalitz.kanaparktechcom.domain.service.location;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelCity;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.location.RepositoryCity;
import com.github.dekalitz.kanaparktechcom.domain.service.base.BaseServiceImpl;

public class ServiceCityImpl extends BaseServiceImpl<ModelCity> implements ServiceCity {

  public ServiceCityImpl(RepositoryCity repository) {
    super(repository);
  }
}