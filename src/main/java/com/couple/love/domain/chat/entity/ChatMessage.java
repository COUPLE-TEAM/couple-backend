package com.couple.love.domain.chat.entity;

import com.couple.love.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chat_message")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatMessage {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "chat_message_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member sender;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member receiver;

    @Column(name="message")
    private String message;

}