package com.broada.one.data.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "provinces")
@ToString
public class Province {
    @Id
    @Column
    private Integer id;
    @Column
    private String provinceId;
    @Column
    private String provinceName;
}
