package com.broada.three.data.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class A0001Request {


    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
}
