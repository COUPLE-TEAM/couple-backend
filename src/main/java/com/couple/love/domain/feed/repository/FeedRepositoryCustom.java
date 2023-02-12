package com.couple.love.domain.feed.repository;

import com.couple.love.domain.feed.entity.Feed;

import java.util.List;

public interface FeedRepositoryCustom {


    List<Feed> findByCoupleId(Long id);
}
