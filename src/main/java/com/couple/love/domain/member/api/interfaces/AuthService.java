package com.couple.love.domain.member.api.interfaces;

import com.couple.love.domain.member.dto.MemberDTO;
import org.springframework.stereotype.Service;

public interface AuthService {

    MemberDTO.SignUpResponse signUp(MemberDTO.SignUpRequest signUpRequest) throws Exception;

    MemberDTO.LoginResponse login(MemberDTO.LoginRequest loginRequest) throws Exception;

}
