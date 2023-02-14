package com.couple.love.domain.memo.controller;


import com.couple.love.common.annotations.AuthMember;
import com.couple.love.common.handler.AuthMemberResolver;
import com.couple.love.domain.member.api.interfaces.TokenService;
import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.member.repository.MemberRepository;
import com.couple.love.domain.memo.entity.Memo;
import com.couple.love.domain.memo.repository.MemoRespository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.request.NativeWebRequest;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@Transactional
public class MemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MemoRespository memoRespository;

    @Autowired
    private MemberRepository memberRepository;

    @Mock
    private AuthMember authMember;

    @Mock
    private MethodParameter parameter;

    @Mock
    private NativeWebRequest request;

    private AuthMemberResolver authMemberResolver;

    private TokenService tokenService;

    @Test
    @DisplayName("정상적인 text와 title을 body로 넘겨도 Member가 존재하지 않을경우 예외처리")
    public void validInputCreateMemoTest() throws Exception {
        String requestJson = "{\"text\":\"test_text\", \"title\": \"test_title\"}";

        mockMvc.perform(post("/api/memo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
                        .with(csrf()))
                .andExpect(status().is4xxClientError());

    }

    @Test
    @DisplayName("메모 조회")
    public void getMemoTest() throws Exception {

        Member member = Member.builder().email("asdf").nickname("sh")
                .password("1234").build();

        memberRepository.save(member);

        Memo memo = Memo.builder().writer(member).text("memo_test_text1").title("memo_test_title1").build();

        memoRespository.save(memo);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/memo/{memoId}", memo.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.text").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.memoId").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.memberId").exists());

    }

    @Test
    @DisplayName("메모 삭제")
    public void deleteMemoTest() throws Exception {


        Member member = Member.builder().email("asdf").nickname("sh")
                .password("1234").build();

        memberRepository.save(member);

        Memo memo = Memo.builder().writer(member).text("memo_test_text1").title("memo_test_title1").build();

        memoRespository.save(memo);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/memo/{memoId}", memo.getId())
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());

    }

}
