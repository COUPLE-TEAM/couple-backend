package com.couple.love.domain.member.entity;

import com.couple.love.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "refresh_token")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class RefreshToken extends BaseTimeEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "refresh_token_id")
    private Long id;

    @Column
    private String token;

}
