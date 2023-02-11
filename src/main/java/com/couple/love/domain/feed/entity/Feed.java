package com.couple.love.domain.feed.entity;

import com.couple.love.domain.couple.entity.Couple;
import com.couple.love.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "feed")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Feed {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "feed")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "couple_id")
    private Couple couple;


    @Column(name="text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member writer;

    @Column(name="feed_public_status")
    private Boolean publicStatus;

}