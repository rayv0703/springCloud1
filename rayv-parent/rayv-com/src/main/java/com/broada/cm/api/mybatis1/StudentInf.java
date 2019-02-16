package com.broada.cm.api.mybatis1;

import com.broada.cm.data.vo.domain.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

public interface StudentInf {
    @RequestMapping(value = "/student/one/findOne/{id}",method = RequestMethod.GET)
    public Student getStudent(@PathVariable("id") @Valid String id);

}
