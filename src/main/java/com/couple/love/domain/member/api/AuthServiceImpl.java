package com.couple.love.domain.member.api;

import com.couple.love.common.message.Message;
import com.couple.love.domain.member.api.interfaces.AuthService;
import com.couple.love.domain.member.api.interfaces.TokenService;
import com.couple.love.domain.member.dto.MemberDTO;
import com.couple.love.domain.member.dto.TokenDTO;
import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Override
    @Transactional
    public MemberDTO.SignUpResponse signUp(MemberDTO.SignUpRequest signUpRequest) throws Exception {
        if (memberRepository.findByEmail(signUpRequest.getEmail()).isPresent()){
            throw new Exception("이미 존재하는 이메일입니다.");
        }

        signUpRequest.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        Member member = memberRepository.save(signUpRequest.toEntity());

        // 토큰 발급
        TokenDTO tokenDTO = tokenService.generateAccessTokenAndRefreshToken(signUpRequest.getEmail(), member);

        return new MemberDTO.SignUpResponse(member, tokenDTO.getAccessToken(), tokenDTO.getRefreshToken());
    }

    @Override
    public MemberDTO.LoginResponse login(MemberDTO.LoginRequest loginRequest) throws Exception {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new Exception(Message.LOGIN_ID_PASSWD_MESSAGE));
        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new Exception(Message.LOGIN_ID_PASSWD_MESSAGE);
        }

        // 토큰 발급
        TokenDTO tokenDTO = tokenService.generateAccessTokenAndRefreshToken(email, member);

        return new MemberDTO.LoginResponse(member, tokenDTO.getAccessToken(), tokenDTO.getRefreshToken());
    }


}
