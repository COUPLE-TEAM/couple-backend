package com.couple.love.domain.memo.entity;

import com.couple.love.domain.couple.entity.Couple;
import com.couple.love.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "memo")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Memo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "memo_id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member writer;

    @ManyToOne
    @JoinColumn(name = "couple_id")
    private Couple couple;

    public void setMember(Member member) {
        this.writer = member;
    }
    public void setMemoTitle(String title){
        this.title = title;
    }
    public void setMemoText(String text) {
        this.text = text;
    }
}