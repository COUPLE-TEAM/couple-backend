package com.couple.love.domain.memo.api.interfaces;

import com.couple.love.common.annotations.AuthMember;
import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.memo.dto.MemoDTO;

import java.util.List;

public interface MemoService {

    // 생성
    MemoDTO.MemoDetailResponse createMemo(@AuthMember Member member, MemoDTO.CreateMemoRequest createMemoRequest) throws Exception;

    // 커플 메모 리스트 조회
    List<MemoDTO.MemoDetailResponse> getAllMemoByCouple(Long coupleId) throws Exception;

    // 멤버별 메모 리스트 조회
    List<MemoDTO.MemoDetailResponse> getAllMemoByMember(Long memberId) throws Exception;

    // 메모 조회
    MemoDTO.MemoDetailResponse getMemo(Long memoId) throws Exception;

    // 수정
    MemoDTO.MemoDetailResponse updateMemo(Long memoId, MemoDTO.UpdateMemoRequest updateMemoRequest) throws Exception;

    // 삭제
    void deleteMemo(Long memoId) throws Exception;
}
