package com.couple.love.domain.diary.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "diary_photo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaryPhoto {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "diary_photo_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @Column(name="photo_url")
    private String photoUrl;

}
