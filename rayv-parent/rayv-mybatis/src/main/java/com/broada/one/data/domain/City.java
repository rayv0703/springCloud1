package com.broada.one.data.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cities")
public class City {
    @Id
    @Column
    private Integer id;
    @Column
    private String cityId;
    @Column
    private String cityName;
    @Column
    private String provinceId;
}
