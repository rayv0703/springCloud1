package com.broada.one.service;

import com.broada.one.data.domain.Course;
import com.broada.one.data.vo.request.A001IM00_RequestVo;
import com.broada.one.data.vo.response.A001IM00_ResponseVo_Grp;

import javax.validation.Valid;
import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findOne(String id);

    A001IM00_ResponseVo_Grp queryCourse(@Valid A001IM00_RequestVo request);
}
