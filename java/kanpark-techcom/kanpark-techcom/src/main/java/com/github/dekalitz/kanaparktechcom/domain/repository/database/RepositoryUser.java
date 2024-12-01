package com.github.dekalitz.kanaparktechcom.domain.repository.database;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelUser;

public interface RepositoryUser extends RepositoryBase<ModelUser> {
     boolean emailIsExists(String email);

     ModelUser findByEmail(String email);

     ModelUser verifyEmailAndPassword(String email, String password);

    ModelUser updateById(String id, ModelUser modelUser);
}
