package com.broada.one.data.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private String sId;
    private String sName;
    private String sBirth;
    private String sSex;
    private String sAdd;

}
