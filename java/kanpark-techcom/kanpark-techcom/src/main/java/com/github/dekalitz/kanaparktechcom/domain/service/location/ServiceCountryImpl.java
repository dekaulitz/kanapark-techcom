package com.github.dekalitz.kanaparktechcom.domain.service.location;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelCountry;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.location.RepositoryCountry;
import com.github.dekalitz.kanaparktechcom.domain.service.base.BaseServiceImpl;

public class ServiceCountryImpl extends BaseServiceImpl<ModelCountry> implements ServiceCountry {

  public ServiceCountryImpl(RepositoryCountry repository) {
    super(repository);
  }
}