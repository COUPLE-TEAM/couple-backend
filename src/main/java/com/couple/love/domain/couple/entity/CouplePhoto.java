package com.couple.love.domain.couple.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "couple_photo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouplePhoto {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "couple_photo_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "couple_id")
    private Couple couple;

    @Column(name = "photo_url")
    private String photoUrl;

    public void updateCouplePhoto(String photoUrl) {

        this.photoUrl = photoUrl;
    }
}
