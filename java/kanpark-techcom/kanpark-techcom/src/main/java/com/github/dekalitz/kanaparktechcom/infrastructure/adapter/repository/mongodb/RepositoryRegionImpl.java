package com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.mongodb;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelCity;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelRegion;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.location.RepositoryCity;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.location.RepositoryRegion;
import org.springframework.data.mongodb.core.MongoTemplate;

public class RepositoryRegionImpl extends MongoRepository<ModelRegion> implements RepositoryRegion {

  public RepositoryRegionImpl(MongoTemplate mongoTemplate,
      Class<ModelRegion> entityClass) {
    super(mongoTemplate, entityClass);
    this.collectionName = "region";
  }
}
