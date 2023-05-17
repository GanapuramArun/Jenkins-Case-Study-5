package ReadData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromXl {

	public static void main(String[] args) throws Exception {
		File file = new File("C:\\UHG_Maven\\jenkins Ass Data\\jenkins data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
//		String cellvalue = sheet.getRow(0).getCell(0).getStringCellValue();
//		System.out.println(cellvalue);
		
		int rowcount = sheet.getPhysicalNumberOfRows();
		
		for (int i = 0; i < rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			
		int cellcount = row.getPhysicalNumberOfCells();
		for (int j = 0; j < cellcount; j++) {
			
			XSSFCell cell = row.getCell(j);
			String cellvalue = getCellValue(cell);
			
			System.out.println("||"+cellvalue);
			
		}
		System.out.println();
			
		}
		wb.close();
		fis.close();
		
	}
	
	
	public static String getCellValue(XSSFCell cell) {
		
		switch(cell.getCellType()) {
		case NUMERIC:
		     return String .valueOf(cell.getNumericCellValue());
		case BOOLEAN:
		     return String .valueOf(cell.getBooleanCellValue());
		case STRING:
		     return cell.getStringCellValue();
		   default:  
			   return cell.getStringCellValue();
		
	}

}
	


	}


