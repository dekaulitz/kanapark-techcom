package com.github.dekalitz.kanaparktechcom.application.mapper;

import com.github.dekalitz.kanaparktechcom.application.dto.ResponseAuthDto;
import com.github.dekalitz.kanaparktechcom.application.dto.RequestUserDto;
import com.github.dekalitz.kanaparktechcom.application.dto.ResponseUserDto;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelUser;

public class UserMapper {
    public UserMapper() {
    }
    public ModelUser toUserModel(RequestUserDto requestUserDto) {
        return ModelUser.builder()
                .username(requestUserDto.getUsername())
                .email(requestUserDto.getEmail())
                .firstname(requestUserDto.getFirstname())
                .lastname(requestUserDto.getLastname())
                .password(requestUserDto.getPassword())
                .authorities(requestUserDto.getAuthorities())
                .build();
    }

    public static ResponseAuthDto constructNewAccessInfo(String accessToken, String refreshToken, ModelUser modelUser) {
        return ResponseAuthDto.builder()
                .username(modelUser.getUsername())
                .email(modelUser.getEmail())
                .accountId(modelUser.getId())
                .authorities(modelUser.getAuthorities())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public static ResponseUserDto fromUserModel(ModelUser modelUser) {
        return ResponseUserDto.builder()
                .id(modelUser.getId())
                .username(modelUser.getUsername())
                .email(modelUser.getEmail())
                .firstname(modelUser.getFirstname())
                .lastname(modelUser.getLastname())
                .authorities(modelUser.getAuthorities())
                .build();
    }
}
