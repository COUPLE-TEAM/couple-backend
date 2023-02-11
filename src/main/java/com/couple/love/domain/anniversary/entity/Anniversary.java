package com.couple.love.domain.anniversary.entity;

import com.couple.love.domain.couple.entity.Couple;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "anniversary")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Anniversary {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "anniversary_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "couple_id")
    private Couple couple;

    @Column(name="name")
    private String name;

    @Column(name="content")
    private String content;

    @Column(name="date")
    private Date date;

}