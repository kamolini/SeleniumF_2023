package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	
	
	private static Workbook getWorkSheet(String fileName) {
		Workbook workbook = null;
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\"+fileName+".xlsx");
		
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}
	
	
	
	
	public static Map<String, String> getData(String fileName, String sheetName, String dataName){
		
		Workbook  workbook = getWorkSheet(fileName); 
		Sheet sheet =  workbook.getSheet(sheetName);
		Map<String, String> map = new  HashMap<String, String>();
		
		int numOfRow = sheet.getLastRowNum();
		
		for(int i=0; i <= numOfRow; i++) {
			
			int numOfCell = sheet.getRow(i).getLastCellNum();
			
			if(sheet.getRow(i).getCell(0) != null) {
				String v = sheet.getRow(i).getCell(0).getStringCellValue();
				if(v.equalsIgnoreCase(dataName)){
					for(int f=1; f<numOfCell; f++) {
						map.put(
								sheet.getRow(0).getCell(f).getStringCellValue(),
								sheet.getRow(i).getCell(f).getStringCellValue()
							);
					}
				}
			}
		}
		return map;
	}
	
	public static Object[][] getDataForDP(String fileName, String sheetName){
		
		Workbook  workbook = getWorkSheet(fileName); 
		Sheet sheet =  workbook.getSheet(sheetName);
		
		int numOfRow = sheet.getLastRowNum();
		System.out.println("-----"+numOfRow);
		Object [][] allData = new String[numOfRow][1];
		
		for(int i=1; i <= numOfRow; i++) {
			System.out.println("-----"+numOfRow);
			if(sheet.getRow(i).getCell(0) != null) {		
				allData[i-1][0] = sheet.getRow(i).getCell(0).getStringCellValue();	
			}
		}
		return allData;
	}

}
