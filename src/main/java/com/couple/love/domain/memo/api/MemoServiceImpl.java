package com.couple.love.domain.memo.api;

import com.couple.love.common.annotations.AuthMember;
import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.memo.api.interfaces.MemoService;
import com.couple.love.domain.memo.dto.MemoDTO;
import com.couple.love.domain.memo.entity.Memo;
import com.couple.love.domain.memo.repository.MemoRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MemoServiceImpl implements MemoService {

    private final MemoRespository memoRespository;

    @Override
    public MemoDTO.CreateMemoResponse createMemo(@AuthMember Member member, MemoDTO.CreateMemoRequest createMemoRequest) throws Exception {

        Memo memo = createMemoRequest.toEntity();

        memo.setMember(member);
        memo.setMemo(createMemoRequest.getTitle(), createMemoRequest.getText());
        memoRespository.save(memo);
        return new MemoDTO.CreateMemoResponse(memo);
    }

    @Override
    @Transactional(readOnly = true)
    public MemoDTO.GetMemoResponse getMemo(Long memoId) throws Exception {

        Memo memo = memoRespository.findById(memoId).orElseThrow();

        return new MemoDTO.GetMemoResponse(memo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MemoDTO.GetMemoResponse> getMemoListByCouple(Long coupleId) throws Exception {

        List<Memo> memoListByCouple = memoRespository.findMemoListByCouple(coupleId);

        return memoListByCouple.stream().map(MemoDTO.GetMemoResponse::new).collect(Collectors.toList());

    }

    @Override
    public void deleteMemo(Long memoId) throws Exception {
        Memo memo = memoRespository.findById(memoId).orElseThrow(() -> new NoSuchElementException("메모가 존재하지 않습니다."));
        memoRespository.delete(memo);
    }

    @Override
    @Transactional
    public MemoDTO.UpdateMemoResponse updateMemo(Long memoId, MemoDTO.UpdateMemoRequest updateMemoRequest) throws Exception {
        Memo memo = memoRespository.findById(memoId).orElseThrow(() -> new NoSuchElementException("해당 메모가 존재하지 않습니다"));

        memo.setMemo(updateMemoRequest.getTitle(), updateMemoRequest.getText());

        return new MemoDTO.UpdateMemoResponse(memo);
    }
}
