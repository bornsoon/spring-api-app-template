package com.app.api.xsstest.controller;

import com.app.api.xsstest.dto.XssTestDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xss")
public class XssTestController {

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public XssTestDto xssTest(XssTestDto xssTestDto) {
        return xssTestDto;
        // 적용전 그대로 "<script>alert(\"xss attrack\");</script>" 반환 -> 위험성
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public XssTestDto xssTest2(@RequestBody XssTestDto xssTestDto) {
        return xssTestDto;
    }
}
