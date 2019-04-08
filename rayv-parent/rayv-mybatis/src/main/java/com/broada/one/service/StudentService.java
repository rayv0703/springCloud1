package com.broada.one.service;

import com.broada.one.data.domain.Student;
import com.broada.one.data.vo.response.A001IM01_ResponseVo;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface StudentService {

    List<Student> findAll();

    A001IM01_ResponseVo findOne(String sId);

    ResponseEntity<Resource> stuInfoDown(String fileNm);

    ResponseEntity<Resource> getStuInfXlx(String[] ids) throws IOException;
}
