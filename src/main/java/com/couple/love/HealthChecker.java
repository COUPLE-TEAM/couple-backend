package com.couple.love;

import com.couple.love.common.annotations.Permission;
import com.couple.love.common.entity.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health-check")
public class HealthChecker {

    @GetMapping()
    @Permission(role = Role.USER)
    public String healthcheck() {
        return "OK";
    }
}
