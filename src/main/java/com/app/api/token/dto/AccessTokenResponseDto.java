package com.app.api.token.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter @Builder
public class AccessTokenResponseDto {

    @Schema(description = "grantType", example = "Bearer", required = true)
    private String grantType;

    @Schema(description = "accessToken", example = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiJBQ0NFU1MiLCJpYXQiOjE3NDgwOTIzNDUsImV4cCI6MTc0ODA5MzI0NSwibWVtYmVySWQiOjEsInJvbGUiOiJBRE1JTiJ9.rIPJZzzDNPZbW_wD-MztShNJi34sYqJTQ3zGh3gmJBoD6H_m6eQCO8zKbLycSCqxswaL63czHOteQ1Mq2wfOag", required = true)
    private String accessToken;

    @Schema(description = "access token 만료 시간", example = "2025-05-24 22:27:25", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date accessTokenExpireTime;
}
