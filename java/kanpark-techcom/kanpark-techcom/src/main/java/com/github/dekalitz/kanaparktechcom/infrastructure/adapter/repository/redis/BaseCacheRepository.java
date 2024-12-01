package com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.redis;

import com.github.dekalitz.kanaparktechcom.domain.repository.cache.CacheRepository;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.BaseRepository;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class BaseCacheRepository<T> extends BaseRepository implements CacheRepository<T> {
    private final RedisTemplate<String, T> redisTemplate;

    public BaseCacheRepository(RedisTemplate<String, T> redisTemplate,String collectionName) {
        super(collectionName);
        this.redisTemplate = redisTemplate;

    }
    @Override
    public void setCacheAndExpired(String key, T payload, long ttl) {
        redisTemplate.opsForValue().set(getCacheKey(key), payload, ttl, TimeUnit.MINUTES);
    }

    @Override
    public T getCache(String key) {
        return redisTemplate.opsForValue().get(getCacheKey(key));
    }

    @Override
    public void clear(String key) {
        redisTemplate.delete(getCacheKey(key));
    }
}
