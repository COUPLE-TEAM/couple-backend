package com.couple.love.domain.member.api;

import com.couple.love.auth.JwtConfigurer;
import com.couple.love.domain.member.dto.TokenDto;
import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.member.entity.RefreshToken;
import com.couple.love.domain.member.repository.MemberRepository;
import com.couple.love.domain.member.repository.RefreshTokenRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenApi implements TokenService {

    private final MemberRepository memberRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtConfigurer jwtConfigurer;


    @Override
    public JwtBuilder generateTokenBuilderByEmailAndExpiration(String email, Long expiredAt) {
        Claims claims = Jwts.claims();

        final SecretKey signingKey = Keys.hmacShaKeyFor(jwtConfigurer.getSecret().getBytes());
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiredAt);

        return Jwts.builder()
                .signWith(signingKey)
                .setClaims(claims)
                .setSubject(email)
                .setExpiration(expiryDate)
                .setIssuedAt(now);
    }

    @Override
    public TokenDto generateAccessTokenAndRefreshToken(String email, Member member) {
        JwtBuilder accessTokenBuilder = generateTokenBuilderByEmailAndExpiration(email, jwtConfigurer.getAccessTokenExp());
        JwtBuilder refreshTokenBuilder = generateTokenBuilderByEmailAndExpiration(email, jwtConfigurer.getRefreshTokenExp());
        String accessToken = accessTokenBuilder.setAudience(member.getEmail()).claim("type", "access").compact();
        String refreshToken = refreshTokenBuilder.setAudience(member.getEmail()).claim("type", "refresh").compact();

        refreshTokenRepository.save(RefreshToken.builder().token(refreshToken).build());
        return new TokenDto(accessToken, refreshToken);
    }

    @Override
    public void verifyToken(String authToken, Boolean isRefreshToken) {

    }

    @Override
    public Long getMemberId(String authToken) {
        String email = parse(authToken).getBody().getSubject();

        return memberRepository.findByEmail(email).orElseThrow(
                IllegalArgumentException::new
        ).getId();
    }

    @Override
    public String getMemberEmail(String authToken) {
        return parse(authToken).getBody().getSubject();
    }

    @Override
    public Jws<Claims> parse(String authToken) {
        final SecretKey signingKey = Keys.hmacShaKeyFor(jwtConfigurer.getSecret().getBytes());
        String token = authToken.replace(jwtConfigurer.getPrefix(), "").trim();
        return Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(token);
    }
}
