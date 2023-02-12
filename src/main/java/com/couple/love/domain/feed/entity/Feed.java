package com.couple.love.domain.feed.entity;

import com.couple.love.common.entity.BaseTimeEntity;
import com.couple.love.domain.couple.entity.Couple;
import com.couple.love.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "feed")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Feed extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "feed_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "couple_id")
    private Couple couple;


    @Column(name="text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member writer;

    @Column(name="public_status")
    private Boolean publicStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "feed", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<FeedPhoto> feedPhotoList = new ArrayList<>();

    public void addPhoto(FeedPhoto photo){
        this.feedPhotoList.add(photo);
        if(photo.getFeed() != this) photo.setFeed(this);
    }

    public void setMember(Member member) {
        this.writer = member;
    }


}