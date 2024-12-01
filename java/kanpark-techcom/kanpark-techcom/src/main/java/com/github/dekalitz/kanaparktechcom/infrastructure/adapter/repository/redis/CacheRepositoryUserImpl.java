package com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.redis;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelUser;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.RepositoryUser;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.RepositoryUserImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Duration;

public class CacheRepositoryUserImpl extends RepositoryUserImpl implements
    RepositoryUser {

    private final RedisTemplate<String, ModelUser> redisTemplate;

    public CacheRepositoryUserImpl(PasswordEncoder passwordEncoder, RedisTemplate<String, ModelUser> redisTemplate) {
        super(passwordEncoder);
        this.redisTemplate = redisTemplate;
    }

    @Override
    public ModelUser findByEmail(String email) {
        final String cachingKey = getCacheKey(email);
        var userModel = redisTemplate.opsForValue().get(cachingKey);
        if (null == userModel) {
            userModel = super.findByEmail(email);
            if (null == userModel) {
                return null;
            }
            redisTemplate.opsForValue().set(cachingKey, userModel, Duration.ofMinutes(15));
        }
        return userModel;
    }
}
