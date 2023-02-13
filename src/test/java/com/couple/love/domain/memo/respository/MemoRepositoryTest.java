package com.couple.love.domain.memo.respository;

import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.member.repository.MemberRepository;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
public class MemoRepositoryTest {

    @Autowired
    MemoRespository memoRespository;

    @Autowired
    MemberRepository memberRepository;
    //create
    @Test
    @DisplayName("메모가 생성된다.")
    public void memoSaveTest() {
        Member member = Member.builder().email("asdf").nickname("sh")
                .password("1234").build();

        Memo memo = Memo.builder().writer(member).text("memo_test_text").title("memo_test_title").build();
        List<Memo> all = memoRespository.findAll();

        assertEquals(1, all.size());
    }

    //read
    @Test
    @DisplayName("메모를 읽어온다.")
    public void memoReadTest() {
        Member member = Member.builder().email("asdf").nickname("sh")
                .password("1234").build();
        Memo memo = Memo.builder().writer(member).text("memo_test_text").title("memo_test_title").build();

        memoRespository.save(memo);

        Optional<Memo> readMemo = memoRespository.findById(memo.getId());

        assertEquals("memo_test_title",readMemo.get().getTitle());

    }
    //update
    @Test
    @DisplayName("메모를 수정한다.")
    public void memoUpdateTest() {

        Member member = Member.builder().email("asdf").nickname("sh")
                .password("1234").build();

        Memo memo = Memo.builder().writer(member).text("memo_test_text").title("memo_test_title").build();
        memoRespository.save(memo);

        Optional<Memo> readMemo = memoRespository.findById(memo.getId());

        readMemo.get().setMemoTitle("change_memo_title");
        memoRespository.save(readMemo.get());

        Optional<Memo> changeTitleMemo = memoRespository.findById(memo.getId());

        assertEquals("change_memo_title",readMemo.get().getTitle());

    }
    //delete
    @Test
    @DisplayName("메모를 삭제한다.")
    public void memoDeleteTest() {

        Member member = Member.builder().email("asdf").nickname("sh")
                .password("1234").build();

        memberRepository.save(member);

        Memo memo1 = Memo.builder().writer(member).text("memo_test_text").title("memo_test_title").build();
        Memo memo2 = Memo.builder().writer(member).text("memo_test_text").title("memo_test_title").build();

        memoRespository.save(memo1);
        memoRespository.save(memo2);

        memoRespository.delete(memo2);

        List<Memo> all = memoRespository.findAll();
        assertEquals(1, all.size());

    }
}
