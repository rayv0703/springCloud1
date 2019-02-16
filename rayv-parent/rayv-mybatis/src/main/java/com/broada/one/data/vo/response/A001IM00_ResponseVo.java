package com.broada.one.data.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

public class A001IM00_ResponseVo {

    @Length(min = 0,max = 20)
    @JsonProperty("c_id")
    @ApiModelProperty(value = "课程id",name = "c_id")
    private String cId;
    @Length(min = 0,max = 20)
    @JsonProperty("c_name")
    @ApiModelProperty(value = "课程名",name = "c_name")
    private String cName;
    @Length(min = 0,max = 20)
    @JsonProperty("t_id")
    @ApiModelProperty(value = "老师Id",name = "t_id")
    private String tId;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }
}
