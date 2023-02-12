package com.couple.love.domain.member.dto;

import com.couple.love.common.entity.Role;
import com.couple.love.common.message.Message;
import com.couple.love.domain.member.entity.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

public class MemberDTO {
    @Data
    public static class SignUpRequest {
        @NotBlank(message = Message.SIGN_UP_ID_MESSAGE)
        private String email;

        @NotBlank(message = Message.SIGN_UP_PASSWD_MESSAGE)
        private String password;

        @NotBlank(message = Message.SIGN_UP_NICKNAME_MESSAGE)
        private String nickname;

        private Role role = Role.USER;

        public Member toEntity(){
            return Member.builder()
                    .email(email)
                    .password(password)
                    .nickname(nickname)
                    .role(role)
                    .build();
        }
    }

    @Data
    public static class SignUpResponse {
        private Long memberId;
        private String email;
        private String nickname;
        private String accessToken;
        private String refreshToken;

        public SignUpResponse(Member member, String accessToken, String refreshToken) {
            this.memberId = member.getId();
            this.email = member.getEmail();
            this.nickname = member.getNickname();
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }
    }

    @Data
    public static class LoginRequest {
        private String email;
        private String password;
    }

    @Data
    public static class LoginResponse{
        private Long memberId;
        private String email;
        private String nickname;
        private String accessToken;
        private String refreshToken;

        public LoginResponse(Member member, String accessToken, String refreshToken) {
            this.memberId = member.getId();
            this.email = member.getEmail();
            this.nickname = member.getNickname();
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }

    }


}
