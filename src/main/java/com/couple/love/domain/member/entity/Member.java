package com.couple.love.domain.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "member")
public class Member {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "member_id")
    private Long id;

    @Column(name="couple_id")
    private Long coupleId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "phone_number")
    private String phoneNumber;

}
