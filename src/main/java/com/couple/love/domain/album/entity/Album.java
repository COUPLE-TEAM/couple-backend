package com.couple.love.domain.album.entity;

import com.couple.love.domain.couple.entity.Couple;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "album")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Album {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "album_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "couple_id")
    private Couple couple;

    @Column(name="title")
    private String title;

    @OneToMany(mappedBy = "album")
    private List<AlbumPhoto> albumPhotos;

}