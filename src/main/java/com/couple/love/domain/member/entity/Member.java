package com.couple.love.domain.member.entity;

import com.couple.love.common.entity.Role;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "member")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Member {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "member_id")
    private Long id;

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

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @JoinColumn(name = "refresh_token_id")
    private RefreshToken refreshToken;

}
