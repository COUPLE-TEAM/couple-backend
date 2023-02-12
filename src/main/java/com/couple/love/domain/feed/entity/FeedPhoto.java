package com.couple.love.domain.feed.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "feed_photo")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FeedPhoto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "feed_photo_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @Column(name="photo_url")
    private String photoUrl;

    public void setFeed(Feed feed) {
        this.feed = feed;
        if (!feed.getFeedPhotoList().contains(this)) {
            feed.getFeedPhotoList().add(this);
        }
    }

}