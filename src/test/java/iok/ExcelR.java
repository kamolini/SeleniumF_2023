package iok;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelR {
	
	
	@Test
	public void T() throws IOException {
		
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\Test.xlsx");
		
		InputStream inputStream = new FileInputStream(file);
		
		Workbook workbook = new XSSFWorkbook(inputStream);
		
		Sheet smoke =  workbook.getSheet("Smoke");
		
		int numOfRow = smoke.getLastRowNum();
		
		for(int i=0; i <= numOfRow; i++) {
			
			int numOfCell = smoke.getRow(i).getLastCellNum();
			
			for(int f=0; f<numOfCell; f++) {
				
				
				if(smoke.getRow(i).getCell(f) != null) {
				
					CellType ct = smoke.getRow(i).getCell(f).getCellType();
					
					if(ct.equals(CellType.STRING)) {
						System.out.print(smoke.getRow(i).getCell(f).getStringCellValue()+ "		");
					}else if (ct.equals(CellType.NUMERIC)) {
						System.out.print(smoke.getRow(i).getCell(f).getNumericCellValue()+ "		");
					}else if (ct.equals(CellType.BOOLEAN )) {
						System.out.print(smoke.getRow(i).getCell(f).getBooleanCellValue()+ "		");
					}else if (ct.equals(CellType.FORMULA )) {
						System.out.print(smoke.getRow(i).getCell(f).getCellFormula()+ "		");
					}
				}else {
					System.out.print( "		");
				}
							
			}		
			System.out.println();
		}
		
		
		
		
		
	}
	
	

}
