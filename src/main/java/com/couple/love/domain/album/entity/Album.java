package com.couple.love.domain.album.entity;

import com.couple.love.domain.couple.entity.Couple;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "album")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Album {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "album")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "couple_id")
    private Couple couple;

    @Column(name="title")
    private String title;

}