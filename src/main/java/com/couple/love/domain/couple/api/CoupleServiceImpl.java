package com.couple.love.domain.couple.api;

import com.couple.love.domain.couple.entity.Couple;
import com.couple.love.domain.couple.repository.CoupleRepository;
import com.couple.love.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoupleServiceImpl implements CoupleService {

    private final CoupleRepository coupleRepository;

    @Override
    public Couple findCoupleByMember(Member member) {
        return coupleRepository.findByMemberId(member.getId());
    }
}
