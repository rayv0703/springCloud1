package com.broada;


import org.apache.poi.hssf.usermodel.*;
import org.assertj.core.util.Lists;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class TestMain {

    public static void main(String[] args) throws FileNotFoundException {
        //制作表头数据
        List<String> header = Arrays.asList("学号","姓名","年龄");
        //制作内容数据
        List<Map<String,Object>> data = new ArrayList<>();
        HashMap<String, Object> map = new LinkedHashMap<>();
        map.put("1","01");
        map.put("2","张三");
        map.put("3","18");
        data.add(map);
        HashMap<String, Object> map1 = new LinkedHashMap<>();
        map1.put("id","02");
        map1.put("name","李四");
        map1.put("age","19");
        data.add(map1);

        //设置文件名
        String fileName = "测试.xls";
        String filePath = "E:/temp/";
        HSSFWorkbook workbook = null;
        //ByteArrayOutputStream bos = new ByteArrayOutputStream();
        FileOutputStream fos = new FileOutputStream(filePath + fileName);
        //调用方法
        try {
            workbook = generateExcel(data, header);
            workbook.write(fos);
            fos.close();
            System.out.println("done");
        } catch (Exception e) {

        }
    }

    public static HSSFWorkbook generateExcel(List<Map<String,Object>> data,List<String> header){
        HSSFWorkbook book = new HSSFWorkbook();

        try {
            //创建sheet1
            HSSFSheet sheet = book.createSheet();
            HSSFCellStyle style = book.createCellStyle();
            HSSFFont font = book.createFont();
            //填充表头
            HSSFRow row = sheet.createRow(0);
            for (int i = 0; i < header.size(); i++) {
                String key = header.get(i);
                HSSFCell cell = row.createCell(i);
                cell.setCellValue(key);
            }
            //填充表格内容
            for (int i = 0; i < data.size(); i++) {
                HSSFRow row2 = sheet.createRow(i + 1);//index:第几行
                Map<String, Object> inner = data.get(i);
                List<Object> value = Lists.newArrayList(inner.values());
                for (int j = 0; j < value.size(); j++) {
                    Object val = value.get(j);
                    HSSFCell cell = row2.createCell(j);//第几列:从0开始
                    cell.setCellValue(val.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }
}
