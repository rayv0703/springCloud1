package com.broada.cm.utils;


import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import java.util.HashMap;

import java.util.Map;

import java.util.Set;

import java.util.Map.Entry;


import org.apache.poi.hssf.usermodel.HSSFCell;

import org.apache.poi.hssf.usermodel.HSSFRow;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;


public class Excel {

    private HSSFWorkbook book;

    /**
     * 解析Excel文件/创建Excel文件
     */

    private String operate;

    /**
     * 文件路径
     */

    private String path;

    /**
     * 解析Excel文件
     */

    public static final String ANALYSIS = "00";

    /**
     * 创建Excel文件
     */

    public static final String CREATE = "01";

    /**
     * 解析得到的值Map
     */

    public Map<Integer, Map<Integer, String>> valueMap;

    private Excel(HSSFWorkbook book) {
        this.book = book;
    }


    /**
     * @param path 要操作的excel 文件路径
     * @param flag 操作类别:解析Excel文件/创建Excel文件
     * @return
     * @author guzi
     * @function 得到操作Excel的实例
     * @process
     */

    public static Excel getExcelInstance(String path, String flag) {
        HSSFWorkbook book;
        File file = new File(path);
        if (!file.getName().endsWith("xls")) {
            return null;
        }
        if (Excel.ANALYSIS.equalsIgnoreCase(flag)) {
            try {
                if (!file.isFile()) {
                    return null;
                }
                book = new HSSFWorkbook(new FileInputStream(file));
            } catch (IOException e) {
                return null;
            }
        } else if (Excel.CREATE.equalsIgnoreCase(flag)) {
            if (!file.exists()) {
                new File(file.getParent()).mkdirs();
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    return null;
                }
            }
            book = new HSSFWorkbook();
        } else {
            return null;
        }
        Excel excel = new Excel(book);
        excel.setPath(path);
        excel.setOperate(flag);
        return excel;
    }


    /**
     * @param cell
     * @return
     * @author guzi
     * @function
     * @process
     */

    public boolean updateExcelCell(Cell cell) {
        HSSFSheet sheet = book.getSheetAt(0);
        HSSFRow row = sheet.getRow(cell.getRowIndex());
        HSSFCell ce = row.getCell(cell.getColumnIndex());
        ce.setCellValue(cell.getStringCellValue());
        try {
            book.write(new FileOutputStream(new File(path)));
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }


    /**
     * @param x 行号
     * @param y 列号
     * @param v 单元格的值
     * @return 是否更新成功
     * @author guzi
     * @function 更新单元格的值
     * @process
     */

    public boolean updateExcelCell(int x, int y, Object v) {

        HSSFSheet sheet = book.getSheetAt(0);

        HSSFRow row = sheet.getRow(x);

        HSSFCell cell = row.getCell(y);

        cell.setCellValue(v.toString());

        try {

            book.write(new FileOutputStream(new File(path)));

        } catch (FileNotFoundException e) {

            return false;

        } catch (IOException e) {

            return false;

        }

        return true;

    }


    /**
     * @param x 行号
     * @param y 列号
     * @return 座标点上的值
     * @author guzi
     * @function 解析Excel表后得到座标点上的值
     * @process
     */
    public String getValue(int x, int y) {
        if (valueMap != null)
            return valueMap.get(x).get(y);
        return null;
    }

    /**
     * @param x 行号
     * @param y 列号
     * @return
     * @author guzi
     * @function 在不解析Excel表的情况下得到座标点的上的值
     * @process
     */

    public String getExcelValue(int x, int y) {

        HSSFSheet sheet = book.getSheetAt(0);

        HSSFRow row = sheet.getRow(x);

        HSSFCell cell = row.getCell(y);

        return getCellString(cell);

    }


    /**
     * @author guzi
     * @function 解析Excel文件
     * @process 仅解析第一个Sheet
     */

    public void analysisExcel() {

        analysisExcel("");

    }


    public Cell getExcelCell(int x, int y) {

        HSSFSheet sheet = book.getSheetAt(0);

        HSSFRow row = sheet.getRow(x);

        return row.getCell(y);

    }


    /**
     * @param sheetName 表名
     * @author guzi
     * @function 解析Excel文件
     * @process 仅解析第一个Sheet
     */

    public void analysisExcel(String sheetName) {

        if (operate.equalsIgnoreCase(CREATE)) {

            return;

        }

        valueMap = new HashMap<Integer, Map<Integer, String>>();

        HSSFSheet sheet = book.getSheet(sheetName);

        if (sheet == null) {

            sheet = book.getSheetAt(0);

        }

        int rowNum = sheet.getLastRowNum();

        int count = 0;

        for (int i = 0; i < rowNum; i++) {

            HSSFRow row = sheet.getRow(i);

            if (row == null) {

                count++;

                if (count == 3) {

                    break;

                }

                continue;

            }

            short cellNum = row.getLastCellNum();

            HashMap<Integer, String> rowMap = new HashMap<Integer, String>();

            for (int j = 0; j < cellNum; j++) {

                HSSFCell cell = row.getCell(j);

                rowMap.put(j, getCellString(cell));

            }

            valueMap.put(i, rowMap);

        }

    }


    /**
     * @param cell
     * @return
     * @function 得到Cell的值
     * @process
     */

    private String getCellString(HSSFCell cell) {

        Object result = null;

        if (cell != null) {

            //单元格类型：Numeric:0,String:1,Formula:2,Blank:3,Boolean:4,Error:5

            int cellType = cell.getCellType();

            switch (cellType) {

                case HSSFCell.CELL_TYPE_STRING:

                    result = cell.getRichStringCellValue().getString();

                    break;

                case HSSFCell.CELL_TYPE_NUMERIC:

                    result = cell.getNumericCellValue();

                    break;

                case HSSFCell.CELL_TYPE_FORMULA:

                    result = null;//cell.getNumericCellValue();

                    break;

                case HSSFCell.CELL_TYPE_BOOLEAN:

                    result = cell.getBooleanCellValue();

                    break;

                case HSSFCell.CELL_TYPE_BLANK:

                    result = null;

                    break;

                case HSSFCell.CELL_TYPE_ERROR:

                    result = null;

                    break;

                default:

                    System.out.println("枚举了所有类型");

                    break;

            }

        }

        return result == null ? "" : result.toString();

    }


    /**
     * @return 解析Excel所得到的值Map
     * @author guzi
     * @function 得到解析Excel所得到的值Map
     * @process
     */

    public Map<Integer, Map<Integer, String>> getValueMap() {

        return valueMap;

    }


    /**
     * @param table 以行号(从0开始)为Key的map,值 是以单元格号(从0开始)为Key的的Map,值是String(可能扩展成对象)
     * @return 修改后的Excel文件路径
     * @author guzi
     * @function 创建Excel文件
     * @process
     */

    public String createExcel(Map<Integer, Map<Integer, String>> table) {

        if (operate.equalsIgnoreCase(ANALYSIS)) {

            return null;

        }

        HSSFSheet sheet = book.createSheet();

        Set<Entry<Integer, Map<Integer, String>>> set = table.entrySet();

        for (Entry<Integer, Map<Integer, String>> entry : set) {

            Map<Integer, String> rowValue = entry.getValue();

            HSSFRow row = sheet.createRow(entry.getKey());

            Set<Entry<Integer, String>> entryCell = rowValue.entrySet();

            for (Entry<Integer, String> ent : entryCell) {

                String cellValue = ent.getValue();

                HSSFCell cell = row.createCell(ent.getKey());

                cell.setCellValue(cellValue);

            }

        }

        try {

            book.write(new FileOutputStream(new File(path)));

        } catch (FileNotFoundException e) {

            return null;

        } catch (IOException e) {

            return null;

        }

        return path;

    }


    public HSSFWorkbook getBook() {

        return book;

    }


    public void setBook(HSSFWorkbook book) {

        this.book = book;

    }


    public String getOperate() {

        return operate;

    }


    public void setOperate(String operate) {

        this.operate = operate;

    }


    public String getPath() {

        return path;

    }


    public void setPath(String path) {

        this.path = path;

    }


}

