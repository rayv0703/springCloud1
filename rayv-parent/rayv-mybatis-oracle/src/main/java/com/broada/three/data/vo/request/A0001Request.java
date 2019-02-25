package com.broada.three.data.vo.request;

import lombok.Data;

import java.util.Date;
@Data
public class A0001Request {

    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
}
