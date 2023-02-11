package com.couple.love.domain.couple.entity;

import com.couple.love.domain.album.entity.Album;
import com.couple.love.domain.anniversary.entity.Anniversary;
import com.couple.love.domain.feed.entity.Feed;
import com.couple.love.domain.feed.entity.FeedComment;
import com.couple.love.domain.feed.entity.FeedFavorite;
import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.memo.entity.Memo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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

    @OneToOne
    @JoinColumn(referencedColumnName="member_id")
    public Member partner1;

    @OneToOne
    @JoinColumn(referencedColumnName="member_id")
    public Member partner2;

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
    private List<Feed> feedList;

    @OneToMany(mappedBy = "couple")
    private List<FeedComment> feedCommentList;

    @OneToMany(mappedBy = "couple")
    private List<FeedFavorite> feedFavoriteList;

    @OneToMany(mappedBy = "couple")
    private List<Memo> memoList;

    @Builder
    public Couple(String coupleName, Date startDate) {
    }

}
