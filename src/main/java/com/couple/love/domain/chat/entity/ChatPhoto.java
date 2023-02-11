package com.couple.love.domain.chat.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chat_photo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatPhoto {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "chat_photo_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_message_id")
    private ChatMessage chatMessage;

    @Column(name="photo_url")
    private String photoUrl;

}