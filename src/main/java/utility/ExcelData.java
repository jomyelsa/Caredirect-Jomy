package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {

	public static Object[][] getDataFromSheet(String filepath) throws InvalidFormatException, IOException
	 {
Object[][] data;

FileInputStream inputStream = new FileInputStream(filepath);
Workbook wb = WorkbookFactory.create(inputStream);
Sheet s = wb.getSheet("Sheet1");

//sheet range
int rowCount = s.getLastRowNum();
int colCount = s.getRow(0).getLastCellNum();

//set data

data = new Object[rowCount][colCount];
for (int i = 1; i <= rowCount; i++) {
	for (int j = 0; j <= colCount - 1; j++) {
		if (!getCellValue(s, 0, j).equals("")) {
			data[i - 1][j] = getCellValue(s, i, j);
		}
	}
}
//System.out.println(data);
//wb.close();
return data;
}

//Get cell value at given row and column

private static String getCellValue(Sheet sheet, int row, int col) {
String value = "";
if (sheet.getRow(row).getCell(col) == null) {
	value = "";
} else if (sheet.getRow(row).getCell(col).getCellType() == Cell.CELL_TYPE_STRING) {
	value = sheet.getRow(row).getCell(col).getStringCellValue();
} else {
	sheet.getRow(row).getCell(col).setCellType(Cell.CELL_TYPE_STRING);
	value = sheet.getRow(row).getCell(col).getStringCellValue();
}
return value;
}


}
