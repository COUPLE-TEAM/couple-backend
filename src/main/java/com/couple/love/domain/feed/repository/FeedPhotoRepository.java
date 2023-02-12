package com.couple.love.domain.feed.repository;

import com.couple.love.domain.feed.entity.FeedPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedPhotoRepository extends JpaRepository<FeedPhoto, Long> {

}
