package com.couple.love.domain.memo.respository;

import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.memo.entity.Memo;
import com.couple.love.domain.memo.repository.MemoRespository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
public class MemoRepositoryTest {

    @Autowired
    MemoRespository memoRespository;

    @Test
    @DisplayName("메모가 생성된다.")
    public void memoSaveTest() {
        Member member = Member.builder().email("asdf").nickname("sh")
                .password("1234").build();

        Memo memo = Memo.builder().writer(member).text("memo_test_text").title("memo_test_title").build();
        List<Memo> all = memoRespository.findAll();

        assertEquals(1, all.size());
    }
}
