package com.couple.love.domain.member.api.interfaces;

import com.couple.love.common.entity.Role;
import com.couple.love.domain.member.dto.TokenDTO;
import com.couple.love.domain.member.entity.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;

public interface TokenService {

    JwtBuilder generateTokenBuilderByEmailAndExpiration(String email, Long expiredAt);
    TokenDTO generateAccessTokenAndRefreshToken(String email, Member member);
    void verifyToken(String authToken, Boolean isRefreshToken);
    Long getMemberId(String authToken);

    Role getMemberRole(String authToken);

    String getMemberEmail(String authToken);
    Jws<Claims> parse(String authToken);

}
