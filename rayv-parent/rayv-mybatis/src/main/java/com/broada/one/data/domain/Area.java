package com.broada.one.data.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "areas")
public class Area {
    @Id
    @Column
    private Integer id;
    @Column
    private String areaId;
    @Column
    private String areaName;
    @Column
    private String cityId;
}
