package com.github.dekalitz.kanaparktechcom.domain.repository.database;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelBase;

import java.util.List;
import java.util.Optional;

public interface RepositoryBase<T extends ModelBase> {
    public T save(T userModel);

    public Optional<T> findById(String id);

    public List<T> findAll();

    public void deleteById(String id);

    public boolean isExists(String id);
}
