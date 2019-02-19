package com.broada.one.data.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 包装类
 */

public class A001IM01_RequestVo {
    @Length
    @JsonProperty("sid")
    @ApiModelProperty(value = "售货员Id",name = "sid")
    private Integer sid;

    @Length(min = 0,max = 200)
    @JsonProperty("name")
    @ApiModelProperty(value = "售货员姓名",name = "sname")
    private String sname;

    @Length(min = 0,max = 20)
    @JsonProperty("phone")
    @ApiModelProperty(value = "售货员电话",name = "consphone")
    private String consphone;

    @Length(min = 0,max = 200)
    @JsonProperty("address")
    @ApiModelProperty(value = "售货员地址",name = "address")
    private String address;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getConsphone() {
        return consphone;
    }

    public void setConsphone(String consphone) {
        this.consphone = consphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
