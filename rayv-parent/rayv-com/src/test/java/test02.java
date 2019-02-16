import com.broada.cm.utils.Excel;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.util.Map;
import java.util.UUID;

public class test02 {

    private static final String filePath = "E:/temp/";

    @Test
    public void test1() throws IOException {
        XSSFWorkbook workbook = null;
        ByteArrayOutputStream bos = null;
        String fileName = "1.xlsx";
        File file = new File(filePath+fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            bos = new ByteArrayOutputStream();
            workbook.write(bos);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        bos.close();
    }
    @Test
    public void test02(){
        for (int i = 0; i < 100; i++) {
            if (i==10)
                return;
            System.out.println(i);
        }
    }
}
