package com.github.dekalitz.kanaparktechcom.application.usecase;

import com.github.dekalitz.kanaparktechcom.application.dto.Response;
import com.github.dekalitz.kanaparktechcom.application.records.ErrorCode;

public class BaseCase<T> {
    public Response<T> ok(T data) {
        return new Response<>(new Response.MetaResponse("ok"), data, null);
    }

    public Response<T> failed(ErrorCode error) {
        return new Response<>(new Response.MetaResponse("ok"), null, new Response.ErrorResponse(error.statusCode(), error.message()));
    }
}
