package com.github.dekalitz.kanaparktechcom.domain.service.base;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelBase;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.RepositoryBase;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
public class BaseServiceImpl<T extends ModelBase> implements BaseService<T> {
    private final RepositoryBase<T> repository;

    public BaseServiceImpl(RepositoryBase<T> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T data) {
        return repository.save(data);
    }

    @Override
    public Optional<T> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
