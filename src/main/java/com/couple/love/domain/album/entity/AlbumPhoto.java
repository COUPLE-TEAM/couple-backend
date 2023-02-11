package com.couple.love.domain.album.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "album_photo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AlbumPhoto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "album_photo_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;


    @Column(name="photo_url")
    private String photoUrl;

}