package com.app.global.jwt.constant;

public enum TokenType {

    ACCESS, REFRESH;

    public static boolean isAccessToken(String tokenType) {
        // enum의 name() 메소드는 String 반환 (비슷한 enum의 메소드인 toString()처럼 재정의는 불가능)
        return TokenType.ACCESS.name().equals(tokenType);
    }

}
