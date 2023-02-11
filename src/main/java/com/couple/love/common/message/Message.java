package com.couple.love.common.message;

public class Message {

    public static final String SIGN_UP_ID_MESSAGE = "아이디를 입력해주세요.";
    public static final String SIGN_UP_PASSWD_MESSAGE = "비밀번호를 입력해주세요.";
    public static final String SIGN_UP_NICKNAME_MESSAGE = "연인에게 보여줄 나의 닉네임을 입력해주세요.";

    public static final String SIGN_UP_PASSWD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$";
    public static final String SIGN_UP_PASSWD_VAILD_MESSAGE = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.";
}
