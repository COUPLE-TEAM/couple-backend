package com.couple.love.domain.couple.repository;

import com.couple.love.domain.couple.entity.Couple;
import com.couple.love.domain.member.entity.Member;

public interface CoupleRepositoryCustom {

    Couple findByMemberId(Long memberId);

}
