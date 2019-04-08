package com.broada.three.data.domain;

import lombok.Data;

@Data
public class EmpBo {

    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;

    private Double sal;
    private Double comm;
    private Integer deptno;

    private String hiredateStart;
    private String hiredateEnd;
}
