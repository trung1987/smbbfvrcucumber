package utils;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	String prjPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) throws IOException {
		try {
			prjPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			workbook.close();
		}
	}

	public int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	public int getColCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colCount;
	}

	public String getCellDataString(int rowNum, int colNum) {
		String cellData = null;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellData;
	}

	public Double getCellDataNumber(int rowNum, int colNum) {
		double cellData = 0;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellData;
	}

	public int checkDataType(int rowNum, int colNum) {
		int result = 0;
		try {
			if (sheet.getRow(rowNum).getCell(colNum) != null) {
				CellType type = sheet.getRow(rowNum).getCell(colNum).getCellType();
				if (type == CellType.NUMERIC) {
					result = 1;
				} else if (type == CellType.STRING) {
					result = 0;
				}
			}else {
				result = 3;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
