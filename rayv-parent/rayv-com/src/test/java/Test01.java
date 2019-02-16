package com.broada.cm;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Test01 {
    public static void main(String[] args) throws IOException {
        String regex = "^[\u4e00-\u9fa5]{0,}$";
        String str  = "中国";
        char[] chars = str.toCharArray();

        byte[] bytes = str.getBytes("UTF-8");
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        int num = bais.available();
        System.out.println(num);

        bais.close();

    }
}
