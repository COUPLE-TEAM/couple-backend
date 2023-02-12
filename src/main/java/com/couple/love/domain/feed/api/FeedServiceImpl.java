package com.couple.love.domain.feed.api;

import com.couple.love.common.annotations.AuthMember;
import com.couple.love.common.handler.S3Uploader;
import com.couple.love.domain.couple.entity.Couple;
import com.couple.love.domain.couple.repository.CoupleRepository;
import com.couple.love.domain.feed.dto.FeedDTO;
import com.couple.love.domain.feed.entity.Feed;
import com.couple.love.domain.feed.entity.FeedPhoto;
import com.couple.love.domain.feed.repository.FeedPhotoRepository;
import com.couple.love.domain.feed.repository.FeedRepository;
import com.couple.love.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService {

    private final FeedRepository feedRepository;
    private final FeedPhotoRepository feedPhotoRepository;
    private final CoupleRepository coupleRepository;
    private final S3Uploader s3Uploader;

    @Override
    public FeedDTO.FeedDetailResponse createFeed(@AuthMember Member member, FeedDTO.FeedCreateRequest request) {

        Feed feed = request.toEntity();

        for (MultipartFile photo : request.getPhotos()) {
            try {
//                String S3Url = s3Uploader.upload(photo, "static");
                FeedPhoto savedPhoto = feedPhotoRepository.save(FeedPhoto.builder().photoUrl("S3Url").build());
                feed.addPhoto(savedPhoto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        feed.setMember(member);
        feedRepository.save(feed);

        return new FeedDTO.FeedDetailResponse(feed);
    }

    @Override
    public FeedDTO.FeedDetailResponse getFeedDetail(Member member, Long feedId) {
        Feed feed = feedRepository.findById(feedId).orElseThrow();
        return new FeedDTO.FeedDetailResponse(feed);
    }

    @Override
    public List<FeedDTO.FeedDetailResponse> getAllFeedByCouple(Member member) {
        Couple couple = coupleRepository.findByMemberId(member.getId());
        List<Feed> feeds = feedRepository.findByCoupleId(couple.getId());
        return feeds.stream().map(FeedDTO.FeedDetailResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<FeedDTO.FeedDetailResponse> getAllFeedByMe(Member me) {
        List<Feed> feeds = feedRepository.findByMemberId(me.getId());
        return feeds.stream().map(FeedDTO.FeedDetailResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<FeedDTO.FeedDetailResponse> getAllFeedByPartner(Member me) {
        Couple couple = coupleRepository.findByMemberId(me.getId());
        Member partner = couple.getPartner1().equals(me) ? couple.getPartner2() : couple.getPartner1();

        List<Feed> feeds = feedRepository.findByMemberId(partner.getId());
        return feeds.stream().map(FeedDTO.FeedDetailResponse::new).collect(Collectors.toList());
    }

    @Override
    public FeedDTO.FeedDetailResponse updateFeed(Member member, Long feedId, FeedDTO.FeedUpdateRequest request) {
        Feed feed = feedRepository.findById(feedId).orElseThrow();
        String updatedText = request.getText();
        Boolean updatedPublicStatus = request.getPublicStatus();
        feed.setText(updatedText);
        feed.setPublicStatus(updatedPublicStatus);

        // TODO : 사진 추가 및 삭제 기능 구현하기
        List<FeedPhoto> originalPhotoList = feedPhotoRepository.findByFeedId(feedId);

        return new FeedDTO.FeedDetailResponse(feed);
    }

    @Override
    public FeedDTO.FeedDetailResponse deleteFeed(Member member, Long feedId) {
        Feed feed = feedRepository.findById(feedId).orElseThrow();
        feedRepository.delete(feed);
        return null;
    }
}
