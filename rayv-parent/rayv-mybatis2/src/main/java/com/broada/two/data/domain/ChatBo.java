package com.broada.two.data.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ChatBo {
    @JsonProperty(value = "ResultType")
    private String ResultType;
    @JsonProperty("OtherInfo")
    private String OtherInfo;
    @JsonProperty("NavigatAddr")
    private String NavigatAddr;
    @JsonProperty("questionList")
    private List<HotQuestion> questionList;

}
