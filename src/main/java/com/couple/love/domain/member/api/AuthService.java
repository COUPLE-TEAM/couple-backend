package com.couple.love.domain.member.api;

import com.couple.love.domain.member.dto.MemberDto;

public interface AuthService {

    MemberDto.SignUpResponse signUp(MemberDto.SignUpRequest signUpRequest) throws Exception;


}
