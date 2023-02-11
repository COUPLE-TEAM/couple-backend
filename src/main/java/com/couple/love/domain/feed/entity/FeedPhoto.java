package com.couple.love.domain.feed.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feed_photo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeedPhoto {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "feed_photo_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @Column(name="photo_url")
    private String photoUrl;

}