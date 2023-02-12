package com.couple.love.domain.feed.controller;

import com.couple.love.common.annotations.AuthMember;
import com.couple.love.domain.feed.api.FeedService;
import com.couple.love.domain.feed.dto.FeedDTO;
import com.couple.love.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feeds/")
public class FeedController {

    private final FeedService feedService;

    @PostMapping("")
    public ResponseEntity<FeedDTO.FeedDetailResponse> createFeed(@AuthMember Member member, @RequestBody FeedDTO.FeedCreateRequest request) {
        FeedDTO.FeedDetailResponse feed = feedService.createFeed(member, request);

        return new ResponseEntity(feed, HttpStatus.OK);

    }

}
