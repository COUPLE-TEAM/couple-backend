package com.couple.love.domain.feed.dto;

import com.couple.love.domain.feed.entity.Feed;
import com.couple.love.domain.feed.entity.FeedPhoto;
import com.couple.love.domain.member.entity.Member;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FeedDTO {

    @Data
    public static class FeedCreateRequest {
        private String text;
        private Boolean publicStatus;
        private List<MultipartFile> photos = new ArrayList<>();

        public Feed toEntity(){
            return Feed.builder()
                    .text(text)
                    .publicStatus(publicStatus)
                    .build();
        }
    }

    @Data
    public static class FeedDetailResponse {
        private Long feedId;
        private String text;
        private Boolean publicStatus;
        private List<String> feedPhotoUrls;
        private String feedPhotoThumbnailUrl;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public FeedDetailResponse(Feed feed) {
            this.feedId = feed.getId();
            this.text = feed.getText();
            this.publicStatus = feed.getPublicStatus();
            this.feedPhotoUrls = feed.getFeedPhotoList().stream().map(FeedPhoto::getPhotoUrl).collect(Collectors.toList());
            this.feedPhotoThumbnailUrl = feed.getFeedPhotoList().isEmpty() ? null : feed.getFeedPhotoList().get(0).getPhotoUrl();
            this.createdAt = feed.getCreatedAt();
            this.updatedAt = feed.getModifiedAt();
        }
    }

    @Data
    public static class FeedSimpleResponse {
    }


}
