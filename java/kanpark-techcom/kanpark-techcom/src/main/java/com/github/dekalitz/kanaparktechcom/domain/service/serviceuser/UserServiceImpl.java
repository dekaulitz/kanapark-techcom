package com.github.dekalitz.kanaparktechcom.domain.service.serviceuser;

import com.github.dekalitz.kanaparktechcom.domain.exception.DomainException;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelUser;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.RepositoryUser;
import com.github.dekalitz.kanaparktechcom.domain.service.base.BaseServiceImpl;

public class UserServiceImpl extends BaseServiceImpl<ModelUser> implements UserService {
    private final RepositoryUser userRepository;

    public UserServiceImpl(RepositoryUser repository) {
        super(repository);
        this.userRepository = repository;
    }

    @Override
    public boolean isEmailExists(String email) {
        return userRepository.emailIsExists(email);
    }

    @Override
    public ModelUser updateById(String id, ModelUser data) throws DomainException {
        if (!userRepository.isExists(id)) {
            throw new DomainException("data not found");
        }
        return userRepository.updateById(id, data);
    }
}
