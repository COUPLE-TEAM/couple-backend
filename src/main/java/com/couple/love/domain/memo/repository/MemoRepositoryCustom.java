package com.couple.love.domain.memo.repository;

import com.couple.love.domain.memo.entity.Memo;

import java.util.List;

public interface MemoRepositoryCustom {

    List<Memo> findByCoupleId(Long id);
}
