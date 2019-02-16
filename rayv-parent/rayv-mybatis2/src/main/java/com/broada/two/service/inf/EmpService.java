package com.broada.two.service.inf;

import com.broada.two.data.domain.EmpInf;
import com.broada.two.data.domain.Student;

import javax.validation.Valid;

public interface EmpService {

    public EmpInf findOne(Integer id);

    Student findStu(@Valid String id);
}
