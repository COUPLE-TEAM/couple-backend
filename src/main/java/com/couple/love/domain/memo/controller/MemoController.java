package com.couple.love.domain.memo.controller;

import com.couple.love.common.annotations.AuthMember;
import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.memo.api.interfaces.MemoService;
import com.couple.love.domain.memo.dto.MemoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/memo/")
public class MemoController {

    private final MemoService memoService;

    // 메모 조회
    @GetMapping("/{memoId}")
    private ResponseEntity<MemoDTO.MemoDetailResponse> getMemo(@PathVariable Long memoId) throws Exception {
        MemoDTO.MemoDetailResponse response = memoService.getMemo(memoId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 메모 전체 조회
    @GetMapping("couple/{coupleId}")
    private ResponseEntity<List<MemoDTO.MemoDetailResponse>> getAllMemoByCouple(@PathVariable Long coupleId) throws Exception {
        List<MemoDTO.MemoDetailResponse> response = memoService.getAllMemoByCouple(coupleId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 메모 멤버별 조회
    @GetMapping("member/{memberId}")
    private ResponseEntity<List<MemoDTO.MemoDetailResponse>> getAllMemoByMember(@PathVariable Long memberId) throws Exception {
        List<MemoDTO.MemoDetailResponse> response = memoService.getAllMemoByMember(memberId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 메모 생성
    @PostMapping("/")
    private ResponseEntity<MemoDTO.MemoDetailResponse> createMemo(@AuthMember Member member, @RequestBody MemoDTO.CreateMemoRequest createMemoRequest) throws Exception {
        MemoDTO.MemoDetailResponse response = memoService.createMemo(member, createMemoRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 메모 수정
    @PatchMapping("/{memoId}")
    private ResponseEntity<MemoDTO.MemoDetailResponse> updateMemo(@PathVariable Long memoId, @RequestBody MemoDTO.UpdateMemoRequest updateMemoRequest) throws Exception {
        MemoDTO.MemoDetailResponse response = memoService.updateMemo(memoId, updateMemoRequest);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 메모 삭제
    @DeleteMapping("/{memoId}")
    private ResponseEntity<Long> deleteMemo(@PathVariable Long memoId) throws Exception {
        memoService.deleteMemo(memoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
