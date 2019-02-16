package com.broada.two.data.domain;

import io.swagger.models.auth.In;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "emp")
public class EmpInf {
    @Id
    @Column
    private Integer id;
    @Column
    private String ename;
    @Column
    private Integer jobId;
    @Column
    private Integer mgr;
    @Column
    private Date joindate;
    @Column
    private Double salary;
    @Column
    private Double bonus;
    @Column
    private Integer deptId;
}
