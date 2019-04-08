package com.broada.three.data.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class A0005Response {
@JsonProperty()
    private Integer deptno;
    private String dname;
    private String loc;
}
