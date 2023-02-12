package com.couple.love.domain.feed.api;

import com.couple.love.common.annotations.AuthMember;
import com.couple.love.domain.feed.dto.FeedDTO;
import com.couple.love.domain.member.entity.Member;

import java.util.List;

public interface FeedService {

    FeedDTO.FeedDetailResponse createFeed(@AuthMember Member member, FeedDTO.FeedCreateRequest request);
    FeedDTO.FeedDetailResponse getFeedDetail(Member member, Long feedId);
    List<FeedDTO.FeedDetailResponse> getAllFeedByCouple(Member member);
    List<FeedDTO.FeedDetailResponse> getAllFeedByMe(Member member);
    List<FeedDTO.FeedDetailResponse> getAllFeedByPartner(Member member);
    FeedDTO.FeedDetailResponse updateFeed(Member member, Long feedId, FeedDTO.FeedUpdateRequest request);
    FeedDTO.FeedDetailResponse deleteFeed(Member member, Long feedId);

}
