package com.couple.love.domain.chat.entity;

import com.couple.love.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chat_room")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "chat_room_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "partner1_id")
    private Member partner1;

    @ManyToOne
    @JoinColumn(name = "partner2_id")
    private Member partner2;

}