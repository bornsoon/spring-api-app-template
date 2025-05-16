package com.app.global.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // Alt + Ins로 구현메소드 찾기
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")   //요청을 허용할 url
                .allowedOrigins("*")
             // .allowedOrigins("http://localhost:8082")  // 브라우저의 네트워크 탭에서 Response 헤더의
                .allowedMethods(                          // access-control-allow-origin에 해당 url 확인 가능
                        HttpMethod.GET.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.PATCH.name(),
                        HttpMethod.DELETE.name(),
                        HttpMethod.OPTIONS.name()
                )
                .maxAge(3600);

    }
}
