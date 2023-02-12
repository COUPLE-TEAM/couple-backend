package com.couple.love.domain.memo.api.interfaces;

import com.couple.love.domain.memo.dto.MemoDTO;
import com.couple.love.domain.memo.entity.Memo;

import java.util.List;

public interface MemoService {

    // 생성
    MemoDTO.CreateMemoResponse createMemo(MemoDTO.CreateMemoRequest createMemoRequest) throws Exception;

    // 커플 메모 리스트 조회
    List<MemoDTO.GetMemoResponse> getMemoListByCouple(Long coupleId) throws Exception;

    // 메모 조회
    MemoDTO.GetMemoResponse getMemo(Long memoId) throws Exception;

    // 수정
    MemoDTO.UpdateMemoResponse updateMemo(Long memoId, MemoDTO.UpdateMemoRequest updateMemoRequest) throws Exception;

    // 삭제
    void deleteMemo(Long memoId) throws Exception;
}
