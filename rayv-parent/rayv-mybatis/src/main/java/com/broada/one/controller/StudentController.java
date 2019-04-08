package com.broada.one.controller;

import com.broada.one.data.domain.Student;
import com.broada.one.data.vo.response.A001IM01_ResponseVo;
import com.broada.one.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "学生管理", tags = {"学生信息管理"})
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "查询所有学生信息", notes = "查询所有")
    @RequestMapping(value = "/one/findAll", method = RequestMethod.GET)
    public List<Student> findAll() {
        List<Student> list = studentService.findAll();
        return list;
    }

    @ApiOperation(value = "查询学生详细信息", notes = "查询学生详细信息")
    @RequestMapping(value = "/one/findOne/{id}", method = RequestMethod.GET)
    public com.broada.cm.data.vo.domain.Student findOne(@ApiParam(name = "id", required = true, value = "学生ID") @PathVariable("id") String id) {
        com.broada.cm.data.vo.domain.Student response = new com.broada.cm.data.vo.domain.Student();
        if (StringUtils.isEmpty(id)) {
            throw new RuntimeException("id为空");
        }
        A001IM01_ResponseVo one = studentService.findOne(id);
        BeanUtils.copyProperties(one,response);
        return response;
    }
    @ApiOperation(value = "学生信息下载",notes = "学生信息下载")
    @RequestMapping(value = "/one/stuInfoDown/{fileNm}",method = RequestMethod.GET)
    public ResponseEntity<Resource> stuInfoDown(@ApiParam(name = "fileNm",value = "学生信息模板名称",required = true)@PathVariable("fileNm") String fileNm){
        ResponseEntity<Resource> resource = null;
        try {
            resource=studentService.stuInfoDown(fileNm);
        }catch (Exception e){
            throw new RuntimeException();
        }
        return resource;
    }
    @ApiOperation(value = "测试JacksonConfig",notes = "测试JacksonConfig")
    @RequestMapping(value = "/one/map",method = RequestMethod.GET)
    public Map<String,Object> getMap(){
        HashMap<String, Object> map = new HashMap<>();
        Student stu = new Student("007", "张大仙", null, "男");
        map.put("学生",stu);
        map.put("关山","车神");
        map.put("地址",null);
        return map;
    }

}
