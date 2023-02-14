package com.couple.love.domain.memo.repository;

import com.couple.love.domain.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoRespository extends JpaRepository<Memo,Long>, MemoRepositoryCustom{

    List<Memo> findByMemberId(Long memberId);
}
