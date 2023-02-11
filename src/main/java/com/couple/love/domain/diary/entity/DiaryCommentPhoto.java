package com.couple.love.domain.diary.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diary_comment_photo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaryCommentPhoto {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "diary_comment_photo_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "diary_comment_id")
    private DiaryComment diaryComment;

    @Column
    private String photoUrl;

}