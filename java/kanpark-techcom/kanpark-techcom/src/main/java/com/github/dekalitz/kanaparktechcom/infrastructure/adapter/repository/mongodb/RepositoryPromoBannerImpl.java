package com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.mongodb;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelPromoBanner;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.promotion.RepositoryBannerPromo;
import org.springframework.data.mongodb.core.MongoTemplate;

public class RepositoryPromoBannerImpl extends MongoRepository<ModelPromoBanner> implements
    RepositoryBannerPromo {

  public RepositoryPromoBannerImpl(MongoTemplate mongoTemplate,
      Class<ModelPromoBanner> entityClass) {
    super(mongoTemplate, entityClass);
    this.collectionName = "promo_banner";
  }
}
