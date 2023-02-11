package com.couple.love.domain.feed.entity;

import com.couple.love.domain.couple.entity.Couple;
import com.couple.love.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feed_favorite")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeedFavorite {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "feed_favorite_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @ManyToOne
    @JoinColumn(name = "couple_id")
    private Couple couple;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}