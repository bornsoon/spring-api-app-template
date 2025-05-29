package com.app.api.health.controller;

import com.app.api.health.dto.HealthCheckResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Tag(name = "health check", description = "서버 상태 체크 API")
// Tag의 name 기반으로 그룹화
@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor   // 초기화되지 않은 필드, 초기화되지 않은 @NonNull로 표시된 필드를 자동 생성자 주입
public class HealthCheckController {

    // 현재 애플리케이션의 환경 설정 정보
    private final Environment environment;

    @Tag(name = "health check")
    // swagger API 상세 설명
    @Operation(summary = "서버 Health Check API", description = "현재 서버가 정상적으로 기동이 된 상태인지 검사하는 API")
    @GetMapping("/health")
    public ResponseEntity<HealthCheckResponseDto> healthCheck() {

        /* 클라이언트 5초 대기 실험
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // log.error("Exception [ErrMsg]: {}", e.getMessage());
            // log.error("Exception [Err_Location]: {}", e.getStackTrace()[0]);
        }
         */

        HealthCheckResponseDto healthCheckResponseDto = HealthCheckResponseDto.builder()
                .health("ok")
                .activeProfiles(Arrays.asList(environment.getActiveProfiles()))
                .build();
        // Edit configuration에서 Active profiles 추가 필요
        return ResponseEntity.ok(healthCheckResponseDto);
    }
}
