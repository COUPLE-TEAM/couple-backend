package com.couple.love.domain.diary.entity;

import com.couple.love.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diary_comment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaryComment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "diary_comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member writer;

    @Column(name = "text")
    private String text;

}