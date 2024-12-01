package com.github.dekalitz.kanaparktechcom.domain.service.serviceproduct;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelProduct;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.RepositoryBase;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.RepositoryProduct;
import com.github.dekalitz.kanaparktechcom.domain.service.base.BaseServiceImpl;

public class ServiceProductImpl extends BaseServiceImpl<ModelProduct> implements ServiceProduct {

  public ServiceProductImpl(RepositoryProduct repository) {
    super(repository);
  }
}
