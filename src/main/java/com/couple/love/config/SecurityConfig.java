package com.couple.love.config;

import com.couple.love.auth.CustomCorsFilter;
import com.couple.love.auth.JwtAccessDeniedHandler;
import com.couple.love.auth.JwtAuthenticationEntryPoint;
import com.couple.love.auth.JwtFilter;
import com.couple.love.domain.member.api.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final TokenService tokenService;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final CustomCorsFilter customCorsFilter;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf().disable() // token을 사용하는 방식이기 때문에 csrf disable
//                .addFilter(customCorsFilter.corsFilter())
//                .addFilterBefore(new JwtFilter(tokenService), UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling()
//                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .accessDeniedHandler(jwtAccessDeniedHandler)
//                .and()
                .authorizeHttpRequests((request) ->
                        request.requestMatchers("/**").permitAll()
                )
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
    }
}
