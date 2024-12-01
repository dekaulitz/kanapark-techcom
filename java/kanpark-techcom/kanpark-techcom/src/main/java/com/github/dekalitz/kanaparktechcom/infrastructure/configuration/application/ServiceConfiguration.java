package com.github.dekalitz.kanaparktechcom.infrastructure.configuration.application;

import com.github.dekalitz.kanaparktechcom.domain.model.ModelCity;
import com.github.dekalitz.kanaparktechcom.domain.service.location.ServiceCity;
import com.github.dekalitz.kanaparktechcom.domain.service.location.ServiceCityImpl;
import com.github.dekalitz.kanaparktechcom.domain.service.location.ServiceCountry;
import com.github.dekalitz.kanaparktechcom.domain.service.location.ServiceCountryImpl;
import com.github.dekalitz.kanaparktechcom.domain.service.location.ServiceRegion;
import com.github.dekalitz.kanaparktechcom.domain.service.location.ServiceRegionImpl;
import com.github.dekalitz.kanaparktechcom.domain.service.serviceproduct.ServiceProduct;
import com.github.dekalitz.kanaparktechcom.domain.service.serviceproduct.ServiceProductImpl;
import com.github.dekalitz.kanaparktechcom.domain.service.servicepromobanner.ServicePromoBanner;
import com.github.dekalitz.kanaparktechcom.domain.service.servicepromobanner.ServicePromoBannerImpl;
import com.github.dekalitz.kanaparktechcom.domain.service.serviceuser.UserService;
import com.github.dekalitz.kanaparktechcom.domain.service.serviceuser.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

  private final RepositoryConfiguration repositoryConfiguration;

  @Autowired
  public ServiceConfiguration(RepositoryConfiguration repositoryConfiguration) {
    this.repositoryConfiguration = repositoryConfiguration;
  }

  @Bean
  public UserService getUserService() {
    return new UserServiceImpl(this.repositoryConfiguration.getUserRepository());
  }

  @Bean
  public ServiceProduct getServiceProduct() {
    return new ServiceProductImpl(this.repositoryConfiguration.getProductRepository());
  }

  @Bean
  public ServicePromoBanner getServicePromoBanner() {
    return new ServicePromoBannerImpl(this.repositoryConfiguration.getRepositoryBannerPromo());
  }

  @Bean
  public ServiceCity getServiceCity() {
    return new ServiceCityImpl(this.repositoryConfiguration.getRepositoryCity());
  }
  @Bean
  public ServiceCountry getServiceCountry() {
    return new ServiceCountryImpl(repositoryConfiguration.getCountryRepository());
  }
  @Bean
  public ServiceRegion getServiceRegion() {
    return new ServiceRegionImpl(repositoryConfiguration.getRepositoryRegion());
  }
}

