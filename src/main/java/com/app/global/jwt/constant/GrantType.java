package com.app.global.jwt.constant;

import lombok.Getter;

@Getter
public enum GrantType { // 토큰 반환: grant 타입 (어떤 방식으로 인증을 하는지에 대한 정보)

    BEARER("Bearer");

    GrantType(String type) {
        this.type = type;
    }
    private String type;
}
