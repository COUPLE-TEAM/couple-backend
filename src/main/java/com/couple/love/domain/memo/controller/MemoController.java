package com.couple.love.domain.memo.controller;

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
    private ResponseEntity<MemoDTO.GetMemoResponse> getMemo(@PathVariable Long memoId) throws Exception {
        MemoDTO.GetMemoResponse response = memoService.getMemo(memoId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 메모 리스트 조회
    @GetMapping("couple/{coupleId}")
    private ResponseEntity<List<MemoDTO.GetMemoResponse>> getMemoList(@PathVariable Long coupleId) throws Exception {
        List<MemoDTO.GetMemoResponse> response = memoService.getMemoListByCouple(coupleId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 메모 생성
    @PostMapping("/")
    private ResponseEntity<MemoDTO.CreateMemoResponse> createMemo(@RequestBody MemoDTO.CreateMemoRequest createMemoRequest) throws Exception {
        MemoDTO.CreateMemoResponse response = memoService.createMemo(createMemoRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 메모 수정
    @PatchMapping("/{memoId}")
    private ResponseEntity<MemoDTO.UpdateMemoResponse> updateMemo(@PathVariable Long memoId, @RequestBody MemoDTO.UpdateMemoRequest updateMemoRequest) throws Exception {
        MemoDTO.UpdateMemoResponse response = memoService.updateMemo(memoId, updateMemoRequest);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 메모 삭제
    @DeleteMapping("/{memoId}")
    private ResponseEntity<Long> deleteMemo(@PathVariable Long memoId) throws Exception {
        memoService.deleteMemo(memoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
