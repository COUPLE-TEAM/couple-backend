package com.couple.love.domain.chat.entity;

import com.couple.love.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "chat_room")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "chat_room_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member partner1;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member partner2;

    @OneToMany
    @JoinColumn(name = "chat_room_id")
    private List<ChatHistory> chatHistoryList;

    @OneToMany
    @JoinColumn(name = "chat_room_id")
    private List<ChatMessage> chatMessageList;
}