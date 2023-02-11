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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "member_photo_id")
    private Long id;

    @OneToOne(mappedBy = "memberPhoto")
    private Member member;

    @Column(name = "photo_url")
    private String photoUrl;


}