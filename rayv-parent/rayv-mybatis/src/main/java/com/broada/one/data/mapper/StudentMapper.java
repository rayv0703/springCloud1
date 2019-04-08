package com.broada.one.data.mapper;

import com.broada.one.data.domain.Student;
import com.broada.one.data.vo.response.A001IM01_ResponseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    List<Student> findAll();

    Student findBySid(@Param("sId") String sId);

    List<Student> findByIds(@Param("ids") String[] ids);
}
