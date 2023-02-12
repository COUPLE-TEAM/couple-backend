package com.couple.love.domain.member.api;

import com.couple.love.domain.member.dto.MemberDTO;
import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class AuthServiceImplTest {

    @Autowired
    AuthServiceImpl authService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("회원가입")
    public void signUpTest() throws Exception {
        MemberDTO.SignUpRequest request = new MemberDTO.SignUpRequest();
        request.setEmail("test@abcd.com");
        request.setNickname("test");
        request.setPassword("1234");

        authService.signUp(request);

        Assertions.assertDoesNotThrow(() -> {
            memberRepository.findByEmail("test@abcd.com").orElseThrow(Exception::new);
        });

    }

    @Test
    @DisplayName("잘못된 이메일로 로그인 시 예외가 발생한다")
    public void inValidEmailLoginTest() throws Exception{
        Member member = Member.builder()
                .email("testuser").password(passwordEncoder.encode("testpassword"))
                .build();
        memberRepository.save(member);

        String invalidEmail = "invalid-email";
        String validPassword = "testpassword";

        MemberDTO.LoginRequest request = new MemberDTO.LoginRequest();
        request.setEmail(invalidEmail);
        request.setPassword(validPassword);

        Assertions.assertThrows(Exception.class, () -> {
            authService.login(request);
        });
    }

    @Test
    @DisplayName("잘못된 비밀번호로 로그인 시 예외가 발생한다")
    public void inValidPasswordLoginTest() {
        Member member = Member.builder()
                .email("testuser").password(passwordEncoder.encode("testpassword"))
                .build();
        memberRepository.save(member);

        String validEmail = "testuser";
        String inValidPassword = "invalid-password";

        MemberDTO.LoginRequest request = new MemberDTO.LoginRequest();
        request.setEmail(validEmail);
        request.setPassword(inValidPassword);

        Assertions.assertThrows(Exception.class, () -> {
            authService.login(request);
        });
    }

    @Test
    @DisplayName("정상적인 이메일과 비밀번호에 대해 로그인이 성공한다")
    public void validLoginTest() {
        Member member = Member.builder()
                .email("testuser").password(passwordEncoder.encode("testpassword"))
                .build();
        memberRepository.save(member);

        String validEmail = "testuser";
        String validPassword = "testpassword";

        MemberDTO.LoginRequest request = new MemberDTO.LoginRequest();
        request.setEmail(validEmail);
        request.setPassword(validPassword);

        Assertions.assertDoesNotThrow(() -> {
            authService.login(request);
        });
    }
}