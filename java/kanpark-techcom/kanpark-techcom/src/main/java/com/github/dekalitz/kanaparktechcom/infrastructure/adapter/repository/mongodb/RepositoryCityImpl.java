package com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.mongodb;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelCity;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.location.RepositoryCity;
import org.springframework.data.mongodb.core.MongoTemplate;

public class RepositoryCityImpl extends MongoRepository<ModelCity> implements RepositoryCity {

  public RepositoryCityImpl(MongoTemplate mongoTemplate,
      Class<ModelCity> entityClass) {
    super(mongoTemplate, entityClass);
    this.collectionName = "promo_banner";
  }
}
