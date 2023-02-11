package com.couple.love.domain.follow.entity;

import com.couple.love.domain.couple.entity.Couple;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "follow")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Follow {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "follow_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="follower_couple")
    private Couple followerCouple;

    @ManyToOne
    @JoinColumn(name="followee_couple")
    private Couple followeeCouple;

}