package com.app.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    // 상수 선언
    TEST(HttpStatus.INTERNAL_SERVER_ERROR, "001", "business exception test")
    ;
    
    // 생성자 <- enum 타입 자체는 암묵적으로 static!!!
    // <=> static ErrorCode(...) {}
    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;
}
