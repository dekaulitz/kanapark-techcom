package com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelUser;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.RepositoryUser;
import com.github.dekalitz.kanaparktechcom.infrastructure.configuration.SingletonUserData;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RepositoryUserImpl extends BaseRepository implements RepositoryUser {
    private final SingletonUserData<ModelUser> singleTon = SingletonUserData.getInstance();

    private final PasswordEncoder passwordEncoder;
    private final static String COLLECTION_NAME = "user";

    public RepositoryUserImpl(PasswordEncoder passwordEncoder) {
        super(COLLECTION_NAME);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ModelUser save(ModelUser modelUser) {
        if (null == modelUser.getCreatedAt()) {
            modelUser.setCreatedAt(new Date());
        }
        modelUser.setUpdatedAt(new Date());
        modelUser.setId(String.valueOf(new Date().getTime()));
        modelUser.setPassword(passwordEncoder.encode(modelUser.getPassword()));
        singleTon.getUserModelList().add(modelUser);
        return modelUser;
    }

    @Override
    @Cacheable(value = "UserModel", key = "#id")
    public Optional<ModelUser> findById(String id) {
        return singleTon.getUserModelList()
                .stream()
                .filter(userModel -> userModel.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<ModelUser> findAll() {
        return singleTon.getUserModelList();
    }

    @Override
    public void deleteById(String id) {
        singleTon.getUserModelList()
                .removeIf(model -> model.getId().equals(id));
    }

    @Override
    public boolean isExists(String id) {
        return singleTon.getUserModelList()
                .stream()
                .allMatch(model -> model.getId().equals(id));
    }

    @Override
    public ModelUser updateById(String id, ModelUser modelUser) {
        return singleTon.getUserModelList().stream()
                .filter(model -> model.getId().equals(id))
                .peek(model -> {
                    model.setUsername(modelUser.getUsername());
                    model.setEmail(modelUser.getEmail());
                    model.setFirstname(modelUser.getFirstname());
                    model.setLastname(modelUser.getLastname());
                })
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean emailIsExists(String email) {
        return singleTon.getUserModelList().stream()
                .anyMatch(userModel -> userModel.getEmail().equals(email));

    }

    @Override
    public ModelUser findByEmail(String email) {
        return singleTon.getUserModelList().stream()
                .filter(model -> model.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ModelUser verifyEmailAndPassword(String email, String password) {
        ModelUser modelUser = singleTon.getUserModelList().stream()
                .filter(model -> model.getEmail().equals(email))
                .findFirst()
                .orElse(null);
        if (null == modelUser || !passwordEncoder.matches(password, modelUser.getPassword())) {
            return null;
        }
        return modelUser;
    }
}
