package com.couple.love.domain.feed.controller;

import com.couple.love.common.annotations.AuthMember;
import com.couple.love.domain.feed.api.FeedService;
import com.couple.love.domain.feed.dto.FeedDTO;
import com.couple.love.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feeds/")
public class FeedController {

    private final FeedService feedService;

    @PostMapping("")
    public ResponseEntity<FeedDTO.FeedDetailResponse> createFeed(@AuthMember Member member, @RequestBody FeedDTO.FeedCreateRequest request) {
        FeedDTO.FeedDetailResponse feed = feedService.createFeed(member, request);
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }

    @GetMapping("/{feedId}")
    public ResponseEntity<FeedDTO.FeedDetailResponse> getFeed(@AuthMember Member member, @PathVariable Long feedId) {
        FeedDTO.FeedDetailResponse feed = feedService.getFeedDetail(member, feedId);
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<FeedDTO.FeedDetailResponse>> getAllFeedByCouple(@AuthMember Member member) {
        List<FeedDTO.FeedDetailResponse> feed = feedService.getAllFeedByCouple(member);
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }

    @GetMapping("/me")
    public ResponseEntity<List<FeedDTO.FeedDetailResponse>> getAllFeedByMe(@AuthMember Member member) {
        List<FeedDTO.FeedDetailResponse> feed = feedService.getAllFeedByMe(member);
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }

    @GetMapping("/partner")
    public ResponseEntity<List<FeedDTO.FeedDetailResponse>> getAllFeedByPartner(@AuthMember Member member) {
        List<FeedDTO.FeedDetailResponse> feed = feedService.getAllFeedByPartner(member);
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }

    @PatchMapping("/{feedId}")
    public ResponseEntity<FeedDTO.FeedDetailResponse> updateFeed(@AuthMember Member member, @PathVariable Long feedId, @RequestBody FeedDTO.FeedUpdateRequest request) {
        FeedDTO.FeedDetailResponse feed = feedService.updateFeed(member, feedId, request);
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }

    @DeleteMapping("/{feedId}")
    public ResponseEntity<FeedDTO.FeedDetailResponse> deleteFeed(@AuthMember Member member, @PathVariable Long feedId) {
        FeedDTO.FeedDetailResponse feed = feedService.deleteFeed(member, feedId);
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }

}
