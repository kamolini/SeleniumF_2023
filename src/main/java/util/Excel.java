package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public static Map<String, String> getData(String fileName, String sheetName, String dataName){
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\"+fileName+".xlsx");

		Map<String, String> map = new  HashMap<String, String>();
		
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Sheet smoke =  workbook.getSheet(sheetName);
		
		int numOfRow = smoke.getLastRowNum();
		
		for(int i=0; i <= numOfRow; i++) {
			
			int numOfCell = smoke.getRow(i).getLastCellNum();
			
				if(smoke.getRow(i).getCell(0) != null) {
					String v = smoke.getRow(i).getCell(0).getStringCellValue();
					if(v.equalsIgnoreCase(dataName)){
						for(int f=1; f<numOfCell; f++) {
							
							map.put(
								smoke.getRow(0).getCell(f).getStringCellValue(),
								smoke.getRow(i).getCell(f).getStringCellValue()
								);
						}
					}
				}
		}
		return map;
	}

}
