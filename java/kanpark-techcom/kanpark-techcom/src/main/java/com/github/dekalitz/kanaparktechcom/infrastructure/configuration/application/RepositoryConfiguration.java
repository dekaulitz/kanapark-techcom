package com.github.dekalitz.kanaparktechcom.infrastructure.configuration.application;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelCity;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelCountry;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelProduct;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelPromoBanner;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelRegion;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelUser;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.location.RepositoryCity;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.location.RepositoryCountry;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.location.RepositoryRegion;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.promotion.RepositoryBannerPromo;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.RepositoryProduct;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.RepositoryUser;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.mongodb.RepositoryCityImpl;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.mongodb.RepositoryCountryImpl;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.mongodb.RepositoryProductImpl;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.mongodb.RepositoryPromoBannerImpl;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.mongodb.RepositoryRegionImpl;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.redis.AuthCacheRepository;
import com.github.dekalitz.kanaparktechcom.infrastructure.adapter.repository.redis.CacheRepositoryUserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class RepositoryConfiguration {

  @Autowired
  private JedisConnectionFactory jedisConnectionFactory;
  @Autowired
  private MongoTemplate mongoTemplate;

  @Bean
  public RedisTemplate<String, ModelUser> userRedisClient() {
    RedisTemplate<String, ModelUser> template = new RedisTemplate<>();
    template.setConnectionFactory(jedisConnectionFactory);
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new Jackson2JsonRedisSerializer<>(ModelUser.class));
    return template;
  }

  @Bean
  public RedisTemplate<String, String> authRedisClient() {
    RedisTemplate<String, String> template = new RedisTemplate<>();
    template.setConnectionFactory(jedisConnectionFactory);
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new Jackson2JsonRedisSerializer<>(String.class));
    return template;
  }

  @Bean
  public AuthCacheRepository getAuthCacheRepository() {
    return new AuthCacheRepository(authRedisClient());
  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Bean
  public RepositoryUser getUserRepository() {
    return new CacheRepositoryUserImpl(getPasswordEncoder(), userRedisClient());
  }

  @Bean
  public RepositoryProduct getProductRepository() {
    return new RepositoryProductImpl(mongoTemplate, ModelProduct.class);
  }

  @Bean
  public RepositoryBannerPromo getRepositoryBannerPromo() {
    return new RepositoryPromoBannerImpl(mongoTemplate, ModelPromoBanner.class);
  }

  @Bean
  public RepositoryCountry getCountryRepository() {
    return new RepositoryCountryImpl(mongoTemplate, ModelCountry.class);
  }

  @Bean
  public RepositoryRegion getRepositoryRegion() {
    return new RepositoryRegionImpl(mongoTemplate, ModelRegion.class);
  }

  @Bean
  public RepositoryCity getRepositoryCity() {
    return new RepositoryCityImpl(mongoTemplate, ModelCity.class);
  }

  /*
  @Bean
  public RepositoryCity getRepositoryCity() {
    return new RepositoryCityImpl(mongoTemplate, ModelCity.class);
  }

   */

}
