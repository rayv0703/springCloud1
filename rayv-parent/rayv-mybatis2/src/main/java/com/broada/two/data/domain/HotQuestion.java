package com.broada.two.data.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HotQuestion {
    @JsonProperty("QuestionId")
    private String QuestionId;
    @JsonProperty("QuestionName")
    private String QuestionName;

    public HotQuestion() {
    }

    public HotQuestion(String questionId, String questionName) {
        QuestionId = questionId;
        QuestionName = questionName;
    }
}
