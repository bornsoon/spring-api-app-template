package com.app.global.error;

import feign.FeignException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

// 클라이언트 오류 시 처리할 로직
@Slf4j
public class FeignClientExceptionErrorDecoder implements ErrorDecoder {

    // Default() 는 ErrorDecoder 구현되어 있음
    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        log.error("{} 요청 실패, status : {}, reason: {}", methodKey, response.status(), response.reason());

        FeignException exception = FeignException.errorStatus(methodKey, response);
        HttpStatus httpStatus = HttpStatus.valueOf(response.status());

        // 5xx 에러 발생하면 재시도
        if(httpStatus.is5xxServerError()) {
            return new RetryableException(
                    response.status(),
                    exception.getMessage(),
                    response.request().httpMethod(),
                    exception,
                    null,   // (상위 버전 시그니처 변경됨)
                    response.request()
            );
        }
        return errorDecoder.decode(methodKey, response);
    }
}
