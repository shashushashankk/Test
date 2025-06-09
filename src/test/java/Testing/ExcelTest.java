package Testing;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelTest {
    //    @Test
    void readTheDataFromExcel() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ER\\Downloads\\waybill-seller-en.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Test");
        XSSFRow row = sheet.getRow(7);
        String val = row.getCell(0).toString();
        System.out.println(val);
    }

    @Test
    void getValOnMap() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ER\\Downloads\\waybill-seller-en.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Test");
        int lastRowNumber = sheet.getLastRowNum();
        int index = 0;
        Map<String, String> map = new LinkedHashMap<>();
//        int row1 = sheet.getLastRowNum();
//        System.out.println(row+" "+row1);
        for (int i = 0; i <= lastRowNumber; i++) {
            String val = sheet.getRow(i).getCell(0).toString();
//            System.out.println(" value is "+val);
            try {
                if (val.equals("No")) {
                    index = i;
                    break;
                }
            } catch (NullPointerException e) {
                continue;
            }
        }
        System.out.println("row Index is " + index);
        Row keyRow = sheet.getRow(index);
        Row valueRow = sheet.getRow(index + 1);
        int lastCellNumb = keyRow.getLastCellNum();
        for (int i = 0; i <= lastCellNumb; i++) {
            try {
                String key = keyRow.getCell(i).toString();
                String val = valueRow.getCell(i).toString();
                if (key.length() < 1 || val.length() < 1) {
                    continue;
                }
                map.put(key, val);
            } catch (NullPointerException e) {
                continue;
            }
        }
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
//        System.out.println(map);
    }
}
