package com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.mongodb;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelCity;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelCountry;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.location.RepositoryCity;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.location.RepositoryCountry;
import org.springframework.data.mongodb.core.MongoTemplate;

public class RepositoryCountryImpl extends MongoRepository<ModelCountry> implements
    RepositoryCountry {

  public RepositoryCountryImpl(MongoTemplate mongoTemplate,
      Class<ModelCountry> entityClass) {
    super(mongoTemplate, entityClass);
    this.collectionName = "promo_banner";
  }
}
