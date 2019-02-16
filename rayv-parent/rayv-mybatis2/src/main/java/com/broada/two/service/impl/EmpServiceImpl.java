package com.broada.two.service.impl;

import com.broada.two.data.domain.EmpInf;
import com.broada.two.data.domain.Student;
import com.broada.two.data.outbound.OutStudentInf;
import com.broada.two.data.repo.EmpRepository;
import com.broada.two.service.inf.EmpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.Optional;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private OutStudentInf outStudentInf;

    public EmpInf findOne(Integer id){
        Optional optional = empRepository.findById(id);
        if (optional.isPresent()) {
            return (EmpInf)optional.get();
        }else {
            return null;
        }
    }

    @Override
    public Student findStu(@Valid String id) {
        com.broada.cm.data.vo.domain.Student stu = outStudentInf.getStudent(id);
        System.out.println(stu.toString());
        Student student = new Student();
        BeanUtils.copyProperties(stu,student);

        return student;
    }
}
