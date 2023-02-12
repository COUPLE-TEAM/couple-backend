package com.couple.love.domain.feed.api;

import com.couple.love.common.annotations.AuthMember;
import com.couple.love.common.handler.S3Uploader;
import com.couple.love.domain.feed.dto.FeedDTO;
import com.couple.love.domain.feed.entity.Feed;
import com.couple.love.domain.feed.entity.FeedPhoto;
import com.couple.love.domain.feed.repository.FeedPhotoRepository;
import com.couple.love.domain.feed.repository.FeedRepository;
import com.couple.love.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService {

    private final FeedRepository feedRepository;
    private final FeedPhotoRepository feedPhotoRepository;
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
}
