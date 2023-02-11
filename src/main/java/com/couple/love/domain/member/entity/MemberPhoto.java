package com.couple.love.domain.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member_photo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberPhoto {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "member_photo_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "photo_url")
    private String photoUrl;


}