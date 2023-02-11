package com.couple.love.domain.couple.entity;

import com.couple.love.domain.album.entity.Album;
import com.couple.love.domain.anniversary.entity.Anniversary;
import com.couple.love.domain.diary.entity.Diary;
import com.couple.love.domain.feed.entity.Feed;
import com.couple.love.domain.feed.entity.FeedComment;
import com.couple.love.domain.feed.entity.FeedFavorite;
import com.couple.love.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Table(name = "couple")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Couple {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "couple_id")
    private Long id;

    @OneToMany
    @JoinColumn(name="couple_id")
    public List<Member> partners;

    @Column(name = "name")
    private String Name;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @OneToOne
    @JoinColumn(name="couple_photo_id")
    private CouplePhoto couplePhoto;

    @OneToMany(mappedBy = "couple")
    private List<Album> albumList;

    @OneToMany(mappedBy = "couple")
    private List<Anniversary> anniversaryList;

    @OneToMany(mappedBy = "couple")
    private List<Diary> diaryList;

    @OneToMany(mappedBy = "couple")
    private List<Feed> feedList;

    @OneToMany(mappedBy = "couple")
    private List<FeedComment> feedCommentList;

    @OneToMany(mappedBy = "couple")
    private List<FeedFavorite> feedFavoriteList;

    @Builder
    public Couple(String coupleName, Date startDate) {
    }

}
