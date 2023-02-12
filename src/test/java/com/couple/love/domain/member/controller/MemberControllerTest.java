package com.couple.love.domain.member.controller;

import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@Transactional
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("입력값이 정상일 때 회원가입이 성공한다")
    public void validInputSignUpTest() throws Exception {
        String requestJson = "{\"email\":\"test@abcd.com\", \"password\": \"1234\", \"nickname\": \"test\"}";

        mockMvc.perform(post("/member/signUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
                        .with(csrf()))
                .andExpect(status().isOk());

        Assertions.assertTrue(memberRepository.findByEmail("test@abcd.com").isPresent());
    }

    @Test
    @DisplayName("입력값이 정상일 때 로그인이 성공한다")
    public void validInputLoginTest() throws Exception {
        Member member = Member.builder()
                .email("test@abcd.com").password(passwordEncoder.encode("1234"))
                .build();
        memberRepository.save(member);

        String requestJson = "{\"email\":\"test@abcd.com\", \"password\": \"1234\"}";

        mockMvc.perform(post("/member/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());
    }
}