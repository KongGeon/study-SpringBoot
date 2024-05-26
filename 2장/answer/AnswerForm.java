package com.mysite.sbb.answer;
// 답변 등록 기능에 폼 적용하기
import jakarta.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
}