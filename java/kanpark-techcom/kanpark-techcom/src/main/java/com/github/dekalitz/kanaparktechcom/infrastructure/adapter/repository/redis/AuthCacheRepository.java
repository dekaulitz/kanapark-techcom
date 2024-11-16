package com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.redis;

import com.github.dekalitz.kanaparktechcom.domain.repository.cache.AuthCache;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.BaseRepository;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class AuthCacheRepository extends BaseCacheRepository<String> implements AuthCache {
    private final static String COLLECTION_NAME = "auth-cache";

    public AuthCacheRepository(RedisTemplate<String, String> redisTemplate) {
        super(redisTemplate, COLLECTION_NAME);
    }

}
