package com.broada.one.controller;

import com.broada.one.data.domain.Course;
import com.broada.one.data.vo.request.A001IM00_RequestVo;
import com.broada.one.data.vo.response.A001IM00_ResponseVo_Grp;
import com.broada.one.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "课程管理",tags = {"学校课程管理"})
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "查询所有课程",notes = "课程集合列表")
    @RequestMapping(value = "/one/findAll",method = RequestMethod.GET)
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @ApiOperation(value = "通过ID查询",notes = "通过ID进行查询")
    @RequestMapping(value = "/one/findOne/{id}",method = RequestMethod.GET)
    public Course findOne(@ApiParam(name = "id",value = "课程id",required = true)@PathVariable("id") String id){
        return courseService.findOne(id);
    }

    @ApiOperation(value = "根据条件查询",notes = "根据多种条件查询课程")
    @RequestMapping(value = "/one/queryCourse",method = RequestMethod.POST)
    public A001IM00_ResponseVo_Grp queryCourse(@ApiParam(name = "request",value = "课程条件信息")@RequestBody @Valid A001IM00_RequestVo request){
        A001IM00_ResponseVo_Grp outVo = new A001IM00_ResponseVo_Grp();
        try {
            outVo=courseService.queryCourse(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outVo;
    }
}
