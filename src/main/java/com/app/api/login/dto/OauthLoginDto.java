package com.app.api.login.dto;

import com.app.global.jwt.dto.JwtTokenDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

public class OauthLoginDto {

    @Getter @Setter
    public static class Request {
        @Schema(description = "소셜 로그인 회원 타입", example = "KAKAO", required = true)
        private String memberType;
    }

    @Getter @Setter
    @Builder @NoArgsConstructor @AllArgsConstructor
    public static class Response {
        @Schema(description = "grantType", example = "Bearer", required = true)
        private String grantType;

        @Schema(description = "accessToken", example = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiJBQ0NFU1MiLCJpYXQiOjE3NDgwOTIzNDUsImV4cCI6MTc0ODA5MzI0NSwibWVtYmVySWQiOjEsInJvbGUiOiJBRE1JTiJ9.rIPJZzzDNPZbW_wD-MztShNJi34sYqJTQ3zGh3gmJBoD6H_m6eQCO8zKbLycSCqxswaL63czHOteQ1Mq2wfOag", required = true)
        private String accessToken;

        @Schema(description = "access token 만료 시간", example = "2025-05-24 22:27:25", required = true)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private Date accessTokenExpireTime;

        @Schema(description = "refreshToken", example = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiJSRUZSRVNIIiwiaWF0IjoxNzQ4MDkyMzQ2LCJleHAiOjE3NDkzMDE5NDUsIm1lbWJlcklkIjoxfQ.jIuPkXoPurUBedGGdUIHm9ec4qscVQSTxDfg3x7i76HEa7K-GYl4XLKQ3h1jaw9lgpmjaBH-QW2cW9gpFPIYzg", required = true)
        private String refreshToken;

        @Schema(description = "refresh token 만료 시간", example = "2025-06-07 22:12:25", required = true)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private Date refreshTokenExpireTime;

        // 변환 메소드
        // Dto 쪽에 숨겨놓으면 service 쪽 가독성이 좋아짐
        public static Response of(JwtTokenDto jwtTokenDto) {
            return Response.builder()
                    .grantType(jwtTokenDto.getGrantType())
                    .accessToken(jwtTokenDto.getAccessToken())
                    .accessTokenExpireTime(jwtTokenDto.getAccessTokenExpireTime())
                    .refreshToken(jwtTokenDto.getRefreshToken())
                    .refreshTokenExpireTime(jwtTokenDto.getRefreshTokenExpireTime())
                    .build();
        }
    }
}
