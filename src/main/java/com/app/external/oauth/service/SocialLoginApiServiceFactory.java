package com.app.external.oauth.service;

import com.app.domain.member.constant.MemberType;
import org.springframework.stereotype.Service;

import java.util.Map;

// MemberType에 맞는 SocialLoginApiService 구현체 반환해 주는 팩토리 클래스
@Service
public class SocialLoginApiServiceFactory {

    private static Map<String, SocialLoginApiService> socialLoginApiServices;

    private SocialLoginApiServiceFactory(Map<String, SocialLoginApiService> socialLoginApiServices) {
        this.socialLoginApiServices = socialLoginApiServices;
    }

    public static SocialLoginApiService getSocialLoginApiService(MemberType memberType) {
        String socialLoginApiServiceBeanName = "";

        if(MemberType.KAKAO.equals(memberType)) {
            socialLoginApiServiceBeanName = "kakaoLoginApiServiceImpl";
        }
        /* 확장 버전
        switch (memberType) {
            case KAKAO -> socialLoginApiServiceBeanName = "kakaoLoginApiServiceImpl";
            case GOOGLE -> socialLoginApiServiceBeanName = "googleLoginApiServiceImpl";
            case NAVER -> socialLoginApiServiceBeanName = "naverLoginApiServiceImpl";
            default -> throw new IllegalArgumentException("지원하지 않는 로그인 방식입니다.");
        } */

        return socialLoginApiServices.get(socialLoginApiServiceBeanName);
    }
}
