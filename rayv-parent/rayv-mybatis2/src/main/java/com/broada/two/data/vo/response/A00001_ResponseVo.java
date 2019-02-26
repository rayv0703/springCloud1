package com.broada.two.data.vo.response;

import com.broada.two.data.domain.ChatBo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class A00001_ResponseVo {
    @JsonProperty(value = "msgEntity")
    private ChatBo msgEntity;
}
