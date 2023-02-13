package com.couple.love.domain.memo.api;


import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.member.repository.MemberRepository;
import com.couple.love.domain.memo.dto.MemoDTO;
import com.couple.love.domain.memo.entity.Memo;
import com.couple.love.domain.memo.repository.MemoRespository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
public class MemoServiceImplTest {

    @Autowired
    MemoServiceImpl memoService;

    @Autowired
    MemoRespository memoRespository;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("메모의 text와 title중 하나라도 비어 있을 경우 예외가 발생한다.")
    public void inValidCreateMemoTest() throws Exception {
        Member member = Member.builder().email("asdf").nickname("sh")
                .password("1234").build();

        MemoDTO.CreateMemoRequest request = new MemoDTO.CreateMemoRequest();
        request.setTitle("test_title");

        Assertions.assertThrows(Exception.class, () -> {
            memoService.createMemo(member,request);
        });

    }

    @Test
    @DisplayName("메모를 삭제하고 Member로 다시 메모를 조회할 때 제대로 삭제가 되어있다.")
    public void deleteMemoTestByMember() throws Exception {

        Memo memo1 = Memo.builder().text("memo_test_text1").title("memo_test_title1").build();
        Memo memo2 = Memo.builder().text("memo_test_text2").title("memo_test_title2").build();

        Member member = Member.builder().email("asdf").nickname("sh")
                .password("1234").build();

        memberRepository.save(member);

        memo1.setMember(member);
        memo2.setMember(member);

        memoRespository.save(memo1);
        memoRespository.save(memo2);


        memoService.deleteMemo(memo1.getId());
        List<MemoDTO.MemoDetailResponse> memoListAfterDelete = memoService.getAllMemoByMember(member.getId());
        assertEquals(1, memoListAfterDelete.size());

    }
}
