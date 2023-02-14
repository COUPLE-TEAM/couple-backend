package com.couple.love.domain.memo.api;


import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.member.repository.MemberRepository;
import com.couple.love.domain.memo.api.interfaces.MemoService;
import com.couple.love.domain.memo.dto.MemoDTO;
import com.couple.love.domain.memo.entity.Memo;
import com.couple.love.domain.memo.repository.MemoRespository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
public class MemoServiceImplTest {

    @Autowired
    MemoService memoService;

    @Autowired
    MemoRespository memoRespository;

    @Autowired
    MemberRepository memberRepository;

    private Memo memo;

    private Member member;

    @BeforeEach
    void initUseCase() {

        member = Member.builder().email("skc").nickname("skc").password("1234").build();
        memberRepository.save(member);

        memo = Memo.builder().writer(member).text("memo_test_text").title("memo_test_title").build();
        memoRespository.save(memo);

        memoService = new MemoServiceImpl(memoRespository);

    }

    //create
    @Test
    @DisplayName("메모의 text가 비어 있을 경우 예외가 발생한다.")
    public void inValidTextCreateMemoTest() throws Exception {

        MemoDTO.CreateMemoRequest request = new MemoDTO.CreateMemoRequest();
        request.setTitle("test_title");

        Assertions.assertThrows(Exception.class, () -> {
            memoService.createMemo(member, request);
        });
    }

    @Test
    @DisplayName("메모의 title이 비어 있을 경우 예외가 발생한다.")
    public void inValidTitleCreateMemoTest() throws Exception {

        MemoDTO.CreateMemoRequest request = new MemoDTO.CreateMemoRequest();
        request.setText("test_text");

        Assertions.assertThrows(Exception.class, () -> {
            memoService.createMemo(member, request);
        });

    }

    //getMemo
    @Test
    @DisplayName("메모를 가져온다.")
    public void getMemo() throws Exception {

        MemoDTO.MemoDetailResponse response = memoService.getMemo(memo.getId());
        assertEquals(memo.getText(), response.getText());
    }

    //getMemoByMember
    @Test
    @DisplayName("멤버별 메모를 가져온다. ")
    public void getMemoByMember() throws Exception {

        List<MemoDTO.MemoDetailResponse> response = memoService.getAllMemoByMember(member.getId());

        assertEquals(memo.getText(), response.get(0).getText());
    }

    //update
    @Test
    @DisplayName("메모 update가 정상적으로 실행된다.")
    public void updateMemoTest() throws Exception {

        MemoDTO.UpdateMemoRequest updateMemoRequest = new MemoDTO.UpdateMemoRequest();
        updateMemoRequest.setTitle("change_title");
        updateMemoRequest.setText("change_text");

        MemoDTO.MemoDetailResponse response = memoService.updateMemo(memo.getId(), updateMemoRequest);

        assertEquals("change_text", response.getText());
        assertEquals("change_title", response.getTitle());

    }

    // delete
    @Test
    @DisplayName("메모를 삭제하고 Member로 다시 메모를 조회할 때 제대로 삭제가 되어있다.")
    public void deleteMemoTestByMember() throws Exception {

        Memo memo1 = Memo.builder().text("memo_test_text1").title("memo_test_title1").build();
        Memo memo2 = Memo.builder().text("memo_test_text2").title("memo_test_title2").build();

        memo1.setMember(member);
        memo2.setMember(member);

        memoRespository.save(memo1);
        memoRespository.save(memo2);

        memoService.deleteMemo(memo1.getId());
        List<MemoDTO.MemoDetailResponse> memoListAfterDelete = memoService.getAllMemoByMember(member.getId());
        assertEquals(memoRespository.findAll().size(), memoListAfterDelete.size());

    }
}
