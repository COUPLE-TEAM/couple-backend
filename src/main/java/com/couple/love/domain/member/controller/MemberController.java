package com.couple.love.domain.member.controller;

import com.couple.love.domain.member.api.interfaces.AuthService;
import com.couple.love.domain.member.api.interfaces.MemberService;
import com.couple.love.domain.member.dto.MemberDTO;
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
    private ResponseEntity<MemberDTO.SignUpResponse> signUp(@RequestBody MemberDTO.SignUpRequest signUpRequest) throws Exception {
        MemberDTO.SignUpResponse response = authService.signUp(signUpRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 로그인
    @PostMapping("/login")
    private ResponseEntity<MemberDTO.LoginResponse> login(@RequestBody MemberDTO.LoginRequest loginRequest) throws Exception {
        MemberDTO.LoginResponse response = authService.login(loginRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
