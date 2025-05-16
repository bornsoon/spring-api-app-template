package com.app.wep;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CorsController {
    // Run/Debug Configuration에서 구성 복사 -> VM 옵션 추가에 "-Dserver.port=8082"
    // 포트 8080 서버, 8082 서버 둘 다 각각 실행 후 localhost:8082/cors 접속해보기
    @GetMapping("/cors")
    public String cors() {
        return "cors";
    }
}
