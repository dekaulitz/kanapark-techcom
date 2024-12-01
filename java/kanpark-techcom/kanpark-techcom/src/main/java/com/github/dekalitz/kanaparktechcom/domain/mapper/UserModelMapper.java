package com.github.dekalitz.kanaparktechcom.domain.mapper;

import com.github.dekalitz.kanaparktechcom.application.dto.RequestUserDto;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelUser;

public class UserModelMapper {

    private UserModelMapper() {
    }

    public static ModelUser fromUserDto(String id, RequestUserDto data) {
        var userModel = ModelUser.builder()
                .username(data.getUsername())
                .email(data.getEmail())
                .firstname(data.getFirstname())
                .lastname(data.getLastname())
                .password(data.getPassword())
                .authorities(data.getAuthorities())
                .build();
        userModel.setId(id);
        return userModel;
    }
}
