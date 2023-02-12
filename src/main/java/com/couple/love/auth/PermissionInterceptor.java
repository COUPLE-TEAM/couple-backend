package com.couple.love.auth;

import com.couple.love.common.annotations.Permission;
import com.couple.love.common.entity.Role;
import com.couple.love.domain.member.api.interfaces.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.naming.AuthenticationException;

@Component
@RequiredArgsConstructor
public class PermissionInterceptor implements HandlerInterceptor {

    private final TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }

        Permission permission = handlerMethod.getMethodAnnotation(Permission.class);
        if (permission == null) {
            return true;
        }

        String token = request.getHeader("Authorization");
        Role role = tokenService.getMemberRole(token);

        if (permission.role().equals(role)) {
            return true;
        }

        throw new AuthenticationException();
    }
}
