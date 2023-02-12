package com.couple.love.domain.couple.api;

import com.couple.love.domain.couple.entity.Couple;
import com.couple.love.domain.member.entity.Member;

public interface CoupleService {
    Couple findCoupleByMember(Member member);

}
