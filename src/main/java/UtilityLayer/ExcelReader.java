package UtilityLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	//check the File is present or not using File class object
	
	public ExcelReader(String excelPath) throws IOException {
		
		File f = new File(excelPath);
		
		FileInputStream fis = new FileInputStream(f);
		
		workbook = new XSSFWorkbook(fis);
	}
	
	public int getTotalRowCount(int sheetIndex)
	{
		sheet= workbook.getSheetAt(sheetIndex);
		int rows = sheet.getLastRowNum()+1;
		return rows;
	}
	
	public int getTotalColumnCount(int sheetIndex)
	{
		sheet=workbook.getSheetAt(sheetIndex);
		int cells = sheet.getRow(0).getLastCellNum();
		return cells;
	}
	
	public Object getSheetTestData(int sheetIndex, int rows, int cells)
	{
		sheet = workbook.getSheetAt(sheetIndex);
		
		XSSFCell cell = sheet.getRow(rows).getCell(cells);
		
		Object data = null;

		if (cell == null) {
			return "";
		}


		if (cell != null) 
		{

		if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK)
		{
			return "";
		}
		else if(cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
		{
			return cell.getStringCellValue();
			
		}
		else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
		{
			return cell.getNumericCellValue();
		}
		else if(cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN)
		{
			return cell.getBooleanCellValue();
		}
		else if(cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA)
		{
			return cell.getCellFormula();
		}
		
		}
		return data;
	}
	
	public Object[][] getAllSheetTestData(int sheetIndex)
	{
		int rows = getTotalRowCount(sheetIndex);
		int cells = getTotalColumnCount(sheetIndex);
		
		Object[][] data = new Object[rows][cells];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cells; j++)
			{
				data[i][j] = getSheetTestData(sheetIndex,i,j);
			}
		}
		return data;
	}
}
