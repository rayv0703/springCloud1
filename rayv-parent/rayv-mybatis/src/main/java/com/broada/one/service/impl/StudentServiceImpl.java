package com.broada.one.service.impl;

import com.broada.one.data.domain.Student;
import com.broada.one.data.mapper.StudentMapper;
import com.broada.one.data.vo.response.A001IM01_ResponseVo;
import com.broada.one.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

@Service
@Transactional
@Slf4j
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
            if (null != student) {
                BeanUtils.copyProperties(student, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public ResponseEntity<Resource> stuInfoDown(String fileNm) {
        ByteArrayOutputStream bos = null;
        System.out.println("fileNm: " + fileNm);
        String downFileName = fileNm + ".xlsx";
        File file = new File(downFilePath + downFileName);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
        }
        System.out.println("downFileName: " + downFileName);
        System.out.println("downFilePath: " + downFilePath);
        XSSFWorkbook workbook = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            //读取excel
            workbook = new XSSFWorkbook(fis);
            bos = new ByteArrayOutputStream();
            workbook.write(bos);
            //workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache,no-store,must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("charset", "utf-8");
        //设置下载文件名
        String filename = null;
        try {
            filename = URLEncoder.encode(downFileName, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        headers.add("Content-Disposition", "attachment;filename=\"" + filename + "\"");
        Resource resource = new InputStreamResource(new ByteArrayInputStream(bos.toByteArray()));
        return ResponseEntity.ok().headers(headers)
                .contentType(MediaType.parseMediaType("application/x-msdownload"))
                .body(resource);
    }

    @Override
    public ResponseEntity<Resource> getStuInfXlx(String[] ids) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String downFileName = null;

        Workbook wb = new XSSFWorkbook();
        //标题行抽出字段
        String[] title = {"序号", "学号", "姓名", "生日", "性别", "住址"};
        //设置sheet名称，并创建新的sheet对象
        String sheetName = "学生信息一览";
        Sheet stuSheet = wb.createSheet(sheetName);
        //获取表头行
        Row titleRow = stuSheet.createRow(0);
        //创建单元格，设置style居中，字体，单元格大小等
        CellStyle style = wb.createCellStyle();
        Cell cell = null;
        //把已经写好的标题行写入excel文件中
        for (int i = 0; i < title.length; i++) {
            cell = titleRow.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        //把从数据库中取得的数据一一写入excel文件中
        Row row = null;
        List<Student> stuList = studentMapper.findByIds(ids);
        log.info(stuList.toString());
        for (int i = 0; i < stuList.size(); i++) {
            //创建list.size()行数据
            row = stuSheet.createRow(i + 1);
            //把值一一写进单元格里
            //设置第一列为自动递增的序号
            row.createCell(0).setCellValue(i + 1);
            row.createCell(1).setCellValue(stuList.get(i).getSId());
            row.createCell(2).setCellValue(stuList.get(i).getSName());
            row.createCell(3).setCellValue(stuList.get(i).getSBirth());
            row.createCell(4).setCellValue(stuList.get(i).getSSex());
            row.createCell(5).setCellValue(stuList.get(i).getSAdd());
        }

        //设置单元格宽度自适应，在此基础上把宽度调至1.5倍
        for (int i = 0; i < title.length; i++) {
            stuSheet.autoSizeColumn(i, true);
            stuSheet.setColumnWidth(i, stuSheet.getColumnWidth(i) * 15 / 10);
        }

        //将表格数据输出到流
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            wb.write(bos);
            //workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //设置文件下载头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache,no-store,must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("charset", "utf-8");
        //设置下载文件名
        String filename = null;
        downFileName = "学生信息表" + sdf.format(new Date()) + ".xlsx";

        try {
            filename = URLEncoder.encode(downFileName, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        headers.add("Content-Disposition", "attachment;filename=\"" + filename + "\"");
        Resource resource = new InputStreamResource(new ByteArrayInputStream(bos.toByteArray()));
        log.info("写入资源文件");
        return ResponseEntity.ok().headers(headers)
                .contentType(MediaType.parseMediaType("application/x-msdownload"))
                .body(resource);
    }
}
