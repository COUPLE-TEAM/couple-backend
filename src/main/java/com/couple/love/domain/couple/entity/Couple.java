package com.couple.love.domain.couple.entity;

import com.couple.love.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Table(name = "couple")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Couple {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "couple_id")
    private Long id;

    @OneToMany
    @JoinColumn(name="couple_id")
    public Collection<Member> partner;

    @Column(name = "couple_name")
    private String coupleName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;


    @Builder
    public Couple(Long partner1, Long partner2, String coupleName, Date startDate) {
    }

}
