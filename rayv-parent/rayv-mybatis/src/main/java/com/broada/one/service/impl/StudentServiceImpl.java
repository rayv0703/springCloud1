package com.broada.one.service.impl;

import com.broada.one.data.domain.Student;
import com.broada.one.data.mapper.StudentMapper;
import com.broada.one.data.vo.response.A001IM01_ResponseVo;
import com.broada.one.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.URLEncoder;
import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Value("${local.filepath}")
    private String downFilePath;

    @Override
    public List<Student> findAll() {

        PageHelper.startPage(0, 3);
        List<Student> list = studentMapper.findAll();
        PageInfo<Student> pages = new PageInfo<>();
        long total = pages.getTotal();
        return list;
    }

    @Override
    public A001IM01_ResponseVo findOne(String sId) {
        A001IM01_ResponseVo response = new A001IM01_ResponseVo();
        try {
            Student student = new Student();
            student = studentMapper.findBySid(sId);
            if (null != student){
                BeanUtils.copyProperties(student,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public ResponseEntity<Resource> stuInfoDown(String fileNm) {
        ByteArrayOutputStream bos = null;
        System.out.println("fileNm: "+fileNm);
        String downFileName = fileNm+".xlsx";
        File file = new File(downFilePath + downFileName);
        if (!file.exists()){
            throw new RuntimeException("文件不存在");
        }
        System.out.println("downFileName: "+downFileName);
        System.out.println("downFilePath: "+downFilePath);
        XSSFWorkbook workbook = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            //读取excel
            workbook=new XSSFWorkbook(fis);
            bos = new ByteArrayOutputStream();
            workbook.write(bos);
            //workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control","no-cache,no-store,must-revalidate");
        headers.add("Pragma","no-cache");
        headers.add("Expires","0");
        headers.add("charset","utf-8");
        //设置下载文件名
        String filename = null;
        try{
            filename = URLEncoder.encode(downFileName,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        headers.add("Content-Disposition","attachment;filename=\""+filename+"\"");
        Resource resource = new InputStreamResource(new ByteArrayInputStream(bos.toByteArray()));
        return ResponseEntity.ok().headers(headers)
                .contentType(MediaType.parseMediaType("application/x-msdownload"))
                .body(resource);
    }
}
