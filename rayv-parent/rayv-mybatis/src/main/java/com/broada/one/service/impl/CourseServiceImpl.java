package com.broada.one.service.impl;

import com.broada.one.data.domain.Course;
import com.broada.one.data.domain.CourseExample;
import com.broada.one.data.mapper.CourseMapper;
import com.broada.one.data.vo.request.A001IM00_RequestVo;
import com.broada.one.data.vo.response.A001IM00_ResponseVo;
import com.broada.one.data.vo.response.A001IM00_ResponseVo_Grp;
import com.broada.one.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAll() {
        CourseExample example = new CourseExample();
        CourseExample.Criteria criteria = example.createCriteria();
        List<Course> courses = courseMapper.selectByExample(example);
        return courses;
    }

    @Override
    public Course findOne(String id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public A001IM00_ResponseVo_Grp queryCourse(@Valid A001IM00_RequestVo request) {
        //A001IM00_ResponseVo outVo = new A001IM00_ResponseVo();
        A001IM00_ResponseVo_Grp outVo = new A001IM00_ResponseVo_Grp();
        Course course = new Course();
        if (request==null||request.getcId().isEmpty()){
            throw new RuntimeException("传入参数异常");
        }
        BeanUtils.copyProperties(request,course);

        try {
            List<Course> courseList=courseMapper.queryCourse(course);
            if (courseList.isEmpty()){
                throw new RuntimeException("查询不到课程信息");
            }
            ArrayList<A001IM00_ResponseVo> CourseList = new ArrayList<>();
            for (Course c : courseList) {
                A001IM00_ResponseVo infCourse = new A001IM00_ResponseVo();
                infCourse.setcId(c.getcId());
                infCourse.setcName(c.getcName());
                infCourse.settId(c.gettId());
                CourseList.add(infCourse);
            }
            outVo.setList(CourseList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outVo;
    }
}
