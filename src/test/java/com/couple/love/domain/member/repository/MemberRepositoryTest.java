package com.couple.love.domain.member.repository;

import com.couple.love.domain.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void memberSaveTest() {
        Member member = new Member();
        member.setEmail("ttt");
        member.setPassword("ttt");
        member.setNickname("zzz");

        memberRepository.save(member);

        List<Member> all = memberRepository.findAll();

        assertEquals(1, all.size());
    }
}