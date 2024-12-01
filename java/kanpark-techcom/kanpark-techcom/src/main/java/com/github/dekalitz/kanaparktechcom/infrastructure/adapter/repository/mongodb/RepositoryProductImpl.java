package com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.mongodb;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelProduct;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.RepositoryProduct;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.BaseRepository;
import org.springframework.data.mongodb.core.MongoTemplate;

public class RepositoryProductImpl extends MongoRepository<ModelProduct> implements
    RepositoryProduct {

  public RepositoryProductImpl(MongoTemplate mongoTemplate, Class<ModelProduct> entityClass) {
    super(mongoTemplate, entityClass);
    this.collectionName = "product";
  }
}
