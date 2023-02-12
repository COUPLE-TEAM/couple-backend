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
    public static class CreateMemoResponse {
        private Long memberId;
        private Long memoId;
        private Long coupleId;

        public CreateMemoResponse(Memo memo) {
            this.memoId = memo.getId();
        }
    }

    @Data
    public static class GetMemoResponse {
        private Long memberId;
        private Long coupleId;
        private String title;
        private String text;

        public GetMemoResponse(Memo memo) {
            this.memberId = memo.getWriter().getId();
            this.coupleId = memo.getCouple().getId();
            this.title = memo.getTitle();
            this.text = memo.getText();
        }
    }

    @Data
    public static class UpdateMemoRequest {
        //        private Member member;
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
    public static class UpdateMemoResponse {
        private Long memberId;
        private Long memoId;
        private Long coupleId;

        public UpdateMemoResponse(Memo memo) {
            this.memoId = memo.getId();
        }
    }


}
