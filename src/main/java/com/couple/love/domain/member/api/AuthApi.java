package com.couple.love.domain.member.api;

import com.couple.love.domain.member.dto.MemberDto;
import com.couple.love.domain.member.dto.TokenDto;
import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthApi implements AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Override
    @Transactional
    public MemberDto.SignUpResponse signUp(MemberDto.SignUpRequest signUpRequest) throws Exception {
        if (memberRepository.findByEmail(signUpRequest.getEmail()).isPresent()){
            throw new Exception("이미 존재하는 이메일입니다.");
        }

        signUpRequest.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        Member member = memberRepository.save(signUpRequest.toEntity());

        // 토큰 발급
        TokenDto tokenDto = tokenService.generateAccessTokenAndRefreshToken(signUpRequest.getEmail(), member);

        return new MemberDto.SignUpResponse(member, tokenDto.getAccessToken(), tokenDto.getRefreshToken());
    }
}
