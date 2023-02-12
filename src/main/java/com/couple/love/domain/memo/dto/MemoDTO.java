package com.couple.love.domain.memo.dto;

import com.couple.love.common.message.Message;
import com.couple.love.domain.couple.entity.Couple;
import com.couple.love.domain.member.entity.Member;
import com.couple.love.domain.memo.entity.Memo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

public class MemoDTO {

    @Data
    public static class CreateMemoRequest {
        //        private Member member;
//        private Couple couple;
        @NotBlank(message = Message.CREATE_MEMO_TITLE_MESSAGE)
        private String title;

        @NotBlank(message = Message.CREATE_MEMO_TEXT_MESSAGE)
        private String text;

        public Memo toEntity() {
            return Memo.builder()
                    .text(text)
                    .title(title)
                    .build();
        }
    }
    @Data
    public static class UpdateMemoRequest {
//        private Couple couple;
        private String title;
        private String text;

        public Memo toEntity() {
            return Memo.builder()
                    .text(text)
                    .title(title)
                    .build();
        }
    }

    @Data
    public static class MemoDetailResponse {

        private Long memoId;
        private Long memberId;
//        private Long coupleId;
        private String title;
        private String text;

        public MemoDetailResponse(Memo memo) {
            this.memoId = memo.getId();
            this.memberId = memo.getWriter().getId();
//            this.coupleId = memo.getCouple().getId();
            this.title = memo.getTitle();
            this.text = memo.getText();
        }
    }

}
