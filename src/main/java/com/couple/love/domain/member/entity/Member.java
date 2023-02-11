package com.couple.love.domain.member.entity;

import com.couple.love.common.entity.Role;
import com.couple.love.domain.chat.entity.ChatHistory;
import com.couple.love.domain.diary.entity.Diary;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "member")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Member {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @JoinColumn(name = "refresh_token_id")
    private RefreshToken refreshToken;
    @OneToOne
    @JoinColumn(name="member_photo_id")
    private MemberPhoto memberPhoto;

    @OneToMany(mappedBy = "member")
    private List<ChatHistory> chatHistoryList;

    @OneToMany(mappedBy = "writer")
    private List<Diary> diaryList;

}
