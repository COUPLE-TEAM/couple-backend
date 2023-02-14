package com.couple.love.domain.memo.repository;

import com.couple.love.domain.memo.entity.Memo;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MemoRepositoryCustomImpl implements MemoRepositoryCustom {

    private final EntityManager em;

    @Override
    public List<Memo> findByCoupleId(Long coupleId) {
        return em.createQuery("select m from Memo m where m.couple.id = :coupleId", Memo.class)
                .setParameter("coupleId", coupleId)
                .getResultList();
    }

    @Override
    public List<Memo> findByMemberId(Long memberId) {
        return em.createQuery("select m from Memo m where m.writer.id = :memberId", Memo.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }
}
