package com.couple.love;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health-check")
public class HealthChecker {

    @Value("${couple.test}")
    private String configTextCheck;

    @GetMapping()
    public String healthcheck() {
        System.out.println(configTextCheck);
        return "OK";
    }
}
