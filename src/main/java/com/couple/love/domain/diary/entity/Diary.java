package com.couple.love.domain.diary.entity;

import com.couple.love.domain.couple.entity.Couple;
import com.couple.love.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diary")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "diary_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name="text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member writer;

    @ManyToOne
    @JoinColumn(name = "couple_id")
    private Couple couple;

}