package com.github.dekalitz.kanaparktechcom.application.usecase.users;

import com.github.dekalitz.kanaparktechcom.application.dto.ResponseUserDto;
import com.github.dekalitz.kanaparktechcom.application.dto.Response;
import com.github.dekalitz.kanaparktechcom.application.exception.ApplicationException;
import com.github.dekalitz.kanaparktechcom.application.mapper.UserMapper;
import com.github.dekalitz.kanaparktechcom.application.records.ErrorCode;
import com.github.dekalitz.kanaparktechcom.application.usecase.BaseCase;
import com.github.dekalitz.kanaparktechcom.application.usecase.UseCase;
import com.github.dekalitz.kanaparktechcom.domain.model.ModelUser;
import com.github.dekalitz.kanaparktechcom.domain.service.serviceuser.UserService;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class GetDetailUsers extends BaseCase<ResponseUserDto> implements
    UseCase<Response<ResponseUserDto>, String> {

  private final UserService userService;

  public GetDetailUsers(UserService userService) {
    this.userService = userService;
  }

  @Override
  public Response<ResponseUserDto> execute(String data) throws ApplicationException {
    Optional<ModelUser> userModel = userService.findById(data);
    if (userModel.isEmpty()) {
      throw new ApplicationException(ErrorCode.errorOnDataNotFound());
    }
    return ok(UserMapper.fromUserModel(userModel.get()));
  }
}
