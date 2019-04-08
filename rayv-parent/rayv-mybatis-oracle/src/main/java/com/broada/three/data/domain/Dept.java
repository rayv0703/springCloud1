package com.broada.three.data.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Dept {

    private Integer deptno;
    private String dname;
    private String loc;

}
