package com.broada.one.data.domain;

import lombok.Data;

@Data

public class Student {

    private String sId;
    private String sName;
    private String sBirth;
    private String sSex;

    public Student() {
    }

    public Student(String sId, String sName, String sBirth, String sSex) {
        this.sId = sId;
        this.sName = sName;
        this.sBirth = sBirth;
        this.sSex = sSex;
    }
}
