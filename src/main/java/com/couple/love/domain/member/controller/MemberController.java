package com.couple.love.domain.member.controller;

import com.couple.love.domain.member.api.AuthApi;
import com.couple.love.domain.member.api.AuthService;
import com.couple.love.domain.member.api.MemberApi;
import com.couple.love.domain.member.api.MemberService;
import com.couple.love.domain.member.dto.MemberDto;
import com.couple.love.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("member/")
public class MemberController {

    private final MemberService memberService;
    private final AuthService authService;
    private final MemberRepository memberRepository;

    // 회원가입
    @PostMapping("/signUp")
    private ResponseEntity<MemberDto.SignUpResponse> signUp(@RequestBody MemberDto.SignUpRequest signUpRequest) throws Exception {
        MemberDto.SignUpResponse response = authService.signUp(signUpRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    // 로그인
    @PostMapping("/login")
    private ResponseEntity<MemberDto.LoginResponse> login(@RequestBody MemberDto.LoginRequest loginRequest) {
        return null;
    }
}
