package com.app.api.feigntest.client;

import com.app.api.health.dto.HealthCheckResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// 원격 서비스에 접근하기 위한 인터페이스
@FeignClient(url = "http://localhost:8080", name = "helloClient") // name은 클라이언트의 bean 이름 지정
public interface HelloClient {

    // 이 메서드를 호출하면 원격 서버에 요청
    @GetMapping(value ="/api/health", consumes = "application/json")
    HealthCheckResponseDto healthCheck();
}
