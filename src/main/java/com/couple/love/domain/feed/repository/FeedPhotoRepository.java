package com.couple.love.domain.feed.repository;

import com.couple.love.domain.feed.entity.FeedPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedPhotoRepository extends JpaRepository<FeedPhoto, Long> {

    List<FeedPhoto> findByFeedId(Long feedId);
}
