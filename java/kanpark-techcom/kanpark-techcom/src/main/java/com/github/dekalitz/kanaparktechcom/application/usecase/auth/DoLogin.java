package com.github.dekalitz.kanaparktechcom.application.usecase.auth;

import com.github.dekalitz.kanaparktechcom.application.dto.RequestLoginDto;
import com.github.dekalitz.kanaparktechcom.application.dto.ResponseAuthDto;
import com.github.dekalitz.kanaparktechcom.application.dto.Response;
import com.github.dekalitz.kanaparktechcom.application.exception.ApplicationException;
import com.github.dekalitz.kanaparktechcom.application.mapper.UserMapper;
import com.github.dekalitz.kanaparktechcom.application.records.ErrorCode;
import com.github.dekalitz.kanaparktechcom.application.usecase.BaseCase;
import com.github.dekalitz.kanaparktechcom.application.usecase.UseCase;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelUser;
import com.github.dekalitz.kanaparktechcom.domain.repository.database.RepositoryUser;
import com.github.dekalitz.kanaparktechcom.infrastructure.configuration.security.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoLogin extends BaseCase<ResponseAuthDto> implements UseCase<Response<ResponseAuthDto>, RequestLoginDto> {
    private final RepositoryUser userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public DoLogin(RepositoryUser userRepository, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public Response<ResponseAuthDto> execute(RequestLoginDto dto) {
        try {
            ModelUser modelUser = userRepository.verifyEmailAndPassword(dto.getEmail(), dto.getPassword());
            if (null == modelUser) {
                throw new ApplicationException(ErrorCode.errorOnInvalidLogin());
            }
            String newAccessToken = jwtTokenProvider.generateAccessToken(modelUser);
            String newRefreshToken = jwtTokenProvider.generateRefreshToken(modelUser.getId());
            return ok(UserMapper.constructNewAccessInfo(newAccessToken, newRefreshToken, modelUser));
        } catch (ApplicationException exception) {
            log.error("doLogin failed ex", exception);
            return failed(exception.getErrorCode());
        }
    }
}

