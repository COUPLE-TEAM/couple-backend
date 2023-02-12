package com.couple.love.domain.feed.dto;

import lombok.Data;

public class FeedPhotoDTO {

    @Data
    public static class FeedPhotoCreateRequest {
        private String photoUrl;
    }

    @Data

    public static class FeedPhotoResponse {
        private String photoId;
        private String photoUrl;
    }

}
