package com.couple.love.domain.couple.repository;

import com.couple.love.domain.couple.entity.Couple;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CoupleRepositoryCustomImpl implements CoupleRepositoryCustom {

    private final EntityManager em;

    @Override
    public Couple findByMemberId(Long memberId) {
        return em.createQuery("select c from Couple c where c.partner1.id = :memberId or c.partner2.id = :memberId", Couple.class)
                .setParameter("memberId", memberId)
                .getSingleResult();
    }
}
