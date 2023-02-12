package com.couple.love.domain.feed.api;

import com.couple.love.common.annotations.AuthMember;
import com.couple.love.domain.feed.dto.FeedDTO;
import com.couple.love.domain.member.entity.Member;

public interface FeedService {

    FeedDTO.FeedDetailResponse createFeed(@AuthMember Member member, FeedDTO.FeedCreateRequest request);
}
