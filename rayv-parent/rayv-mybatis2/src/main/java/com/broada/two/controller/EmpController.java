package com.broada.two.controller;

import com.broada.two.data.domain.EmpInf;
import com.broada.two.data.domain.Student;
import com.broada.two.service.inf.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value = "员工管理",tags = {"员工管理"})
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/two/findOne/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "通过id查找员工",notes = "通过ID查找")
    public EmpInf findOne(@PathVariable(value = "id",required = true)@Valid Integer id){
        return empService.findOne(id);
    }
    @RequestMapping(value ="/two/findStu/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "通过学生id查找",notes = "通过outbound")
    public Student findStu(@PathVariable(value = "id",required = true)@Valid String id){
        return empService.findStu(id);
    }

}
