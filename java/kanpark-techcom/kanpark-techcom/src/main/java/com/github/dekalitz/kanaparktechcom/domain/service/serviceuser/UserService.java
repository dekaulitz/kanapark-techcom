package com.github.dekalitz.kanaparktechcom.domain.service.serviceuser;

import com.github.dekalitz.kanaparktechcom.domain.exception.DomainException;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelUser;
import com.github.dekalitz.kanaparktechcom.domain.service.base.BaseService;

public interface UserService extends BaseService<ModelUser> {
     boolean isEmailExists(String email);

    ModelUser updateById(String id, ModelUser data) throws DomainException;
}
