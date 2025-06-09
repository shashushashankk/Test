package arraysPractice;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class GetDataFromExcelAsMap {
	public static void main(String[] args) {
		String excelPath = "C:\\Users\\ER\\Downloads\\Payments_PayCraft_TestData.xlsx";
		String sheetname = "Revenue Summary";
		String TCName = "SCR1095";
		int reqRowIndex = -1;
		int reqCellIndex = -1;
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		FileInputStream fileInputStream = null;
		XSSFWorkbook workbook = null;
		try {
			fileInputStream = new FileInputStream(new File(excelPath));
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getLocalizedMessage());
		}
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int lastRowIndex = sheet.getLastRowNum();
		for (int i = 0; i <= lastRowIndex; i++) {
			String rowVal = "";
			try {
				rowVal = sheet.getRow(i).getCell(0).toString();
			} catch (Exception e) {
				continue;
//				System.out.println(e.getLocalizedMessage());
			}
			if (rowVal.equalsIgnoreCase(TCName)) {
				reqRowIndex = i - 1;
				break;
			}
		}
		int lastCellIndex = -1;
		try {
			lastCellIndex = sheet.getRow(reqRowIndex).getLastCellNum();
		} catch (NullPointerException e) {
			Reporter.log(e.getLocalizedMessage());
		}

		for (int i = 0; i < lastCellIndex; i++) {
			if (reqRowIndex != -1) {
				System.out.println("cell is " + i);
				String key = "";
				String val = "";
				try {
					key = sheet.getRow(reqRowIndex).getCell(i).toString();
					val = sheet.getRow(reqRowIndex + 1).getCell(i).toString();

				} catch (NullPointerException e) {
					continue;
				}
//				if (!key.isBlank() && !key.isEmpty() && key != null) {
//					map.put(key, val);
//				}
			}
		}
		System.out.println(map);
	}

}
