package com.couple.love.domain.feed.repository;

import com.couple.love.domain.feed.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Long>, FeedRepositoryCustom {

    List<Feed> findByMemberId(Long memberId);
}
