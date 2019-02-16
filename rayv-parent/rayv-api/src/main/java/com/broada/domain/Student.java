package com.broada.domain;



import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer sid;
    @Column
    private String gender;
    @Column
    private Integer classId;
    @Column
    private String sname;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", gender='" + gender + '\'' +
                ", classId=" + classId +
                ", sname='" + sname + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(String gender, Integer classId, String sname) {
        this.gender = gender;
        this.classId = classId;
        this.sname = sname;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
