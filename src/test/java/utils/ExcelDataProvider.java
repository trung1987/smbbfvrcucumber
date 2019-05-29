package utils;

import java.io.IOException;
import java.util.ArrayList;


public class ExcelDataProvider {
	static ArrayList<String> array = new ArrayList<String>();
	

	public static ArrayList<String> getData(String excelPath, String sheetName) throws IOException {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		String cellData = null;
		
		for (int i = 1; i < rowCount; i++) {
			String dataCell= null;
			for (int j = 0; j < colCount; j++) {
				ExcelUtils utils = new ExcelUtils(excelPath, sheetName);
				int cellType = utils.checkDataType(i, j);
				if(cellType == 0) {
					cellData = excel.getCellDataString(i, j);
				}else if(cellType == 1) {
					cellData = excel.getCellDataNumber(i, j)+ "";
				}else {
					cellData = null;
				}
				if(dataCell != null) {
					dataCell = dataCell + ";" + cellData;
				}else{
					dataCell = cellData;
				}
			}
			array.add(dataCell);
		}
		return array;
	}
	
	
}
