package com.broada.one.data.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

public class A001IM01_ResponseVo {

    @Length(min = 0,max = 20)
    @JsonProperty("s_id")
    @ApiModelProperty(value = "学生id",name = "s_id")
    private String sId;
    @Length(min = 0,max = 20)
    @JsonProperty("s_name")
    @ApiModelProperty(value = "学生名字",name = "s_name")
    private String sName;
    @Length(min = 0,max = 20)
    @JsonProperty("s_birth")
    @ApiModelProperty(value = "出生年月",name = "s_birth")
    private String sBirth;

    @Length(min = 0,max = 20)
    @JsonProperty("s_sex")
    @ApiModelProperty(value = "性别",name = "s_sex")
    private String sSex;

    @Override
    public String toString() {
        return "A001IM01_ResponseVo{" +
                "sId='" + sId + '\'' +
                ", sName='" + sName + '\'' +
                ", sBirth='" + sBirth + '\'' +
                ", sSex='" + sSex + '\'' +
                '}';
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsBirth() {
        return sBirth;
    }

    public void setsBirth(String sBirth) {
        this.sBirth = sBirth;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }
}
