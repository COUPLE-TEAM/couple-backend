package com.couple.love.domain.feed.repository;

import com.couple.love.domain.feed.entity.Feed;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FeedRepositoryCustomImpl implements FeedRepositoryCustom {

    private final EntityManager em;

    @Override
    public List<Feed> findByCoupleId(Long coupleId) {
        return em.createQuery("select f from Feed f where f.couple.id = :coupleId", Feed.class)
                .setParameter("coupleId", coupleId)
                .getResultList();
    }

}
