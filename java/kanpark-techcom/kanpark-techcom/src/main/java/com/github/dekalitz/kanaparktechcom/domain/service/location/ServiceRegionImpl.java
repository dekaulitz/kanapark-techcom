package com.github.dekalitz.kanaparktechcom.domain.service.location;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelRegion;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.location.RepositoryRegion;
import com.github.dekalitz.kanaparktechcom.domain.service.base.BaseServiceImpl;

public class ServiceRegionImpl extends BaseServiceImpl<ModelRegion> implements ServiceRegion {

  public ServiceRegionImpl(RepositoryRegion repository) {
    super(repository);
  }
}