package com.couple.love.domain.diary.entity;

import com.couple.love.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diary_favorite")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaryFavorite {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "diary_favorite_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
