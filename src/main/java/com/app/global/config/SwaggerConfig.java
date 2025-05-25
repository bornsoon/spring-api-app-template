package com.app.global.config;

import com.app.global.resolver.memberinfo.MemberInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean  // Swagger 설정의 핵심이 되는 bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()  // ApiSelectorBuilder 생성
                // 문서화할 API 패키지 경로 todo 패키지 경로 수정
                .apis(RequestHandlerSelectors.basePackage("com.app.api"))
                // path 조건에 따라서 API 문서화 (any: 모든 api) todo API 경로 수정
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(apiInfo())  // API 문서에 대한 정보 추가
                .useDefaultResponseMessages(false)   // swagger에서 제공하는 기본 응답 코드 설명 제거
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .ignoredParameterTypes(MemberInfo.class)  // member-info-controller에서의 파라미터 입력값 없애기
                ;
    }

    // Swagger 커스터마이징
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API 문서")
                .description("API에 대해서 설명해주는 문서입니다.")
                .version("1.0")
                .build();
    }

    // 헤더에 Authorization 추가하기 위한 메소드들
    // swagger 문서에서 excute 위해서는 좌물쇠 클릭해서 "BEARER {ACCESS_TOKEN}" 입력해서 로그인 필요
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }
}