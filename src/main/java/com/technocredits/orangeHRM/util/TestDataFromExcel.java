package com.technocredits.orangeHRM.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestDataFromExcel {

	Workbook mybook = null;
	Sheet dataSheet = null;
	public TestDataFromExcel(String path, String sheetName) throws IOException{
		FileInputStream input = new FileInputStream(path);
		
		mybook = new XSSFWorkbook(input);
		dataSheet = mybook.getSheet(sheetName);
		
	}
	
	public TestDataFromExcel(String path, int sheetIndex) throws IOException{
		FileInputStream input = new FileInputStream(path);
		
		mybook = new XSSFWorkbook(input);
		dataSheet = mybook.getSheetAt(sheetIndex);
		
	}
	
//return rows for sheet with mentioned name
	public int totalRows(){
		int totalRows = dataSheet.getLastRowNum();
		System.out.println(totalRows);
		return totalRows;
	}

	
	public int totalCol(int rowIndex){
		int totalCol = dataSheet.getRow(rowIndex).getLastCellNum();
		
		return totalCol;
	}
	
	public int maxColInRow(){
		int rows = dataSheet.getLastRowNum()+1;
		int maxCol=0;
		int totalCol=0;
		for(int i=0;i<rows;i++){
			totalCol = dataSheet.getRow(i).getLastCellNum();
			if(totalCol>maxCol){
				maxCol = totalCol;
			}
			
		}
		return maxCol;
	}
	
	public String getData(int rowIndex, int colIndex){

		if(dataSheet.getRow(rowIndex).getCell(colIndex).getCellTypeEnum()==CellType.STRING){
			return dataSheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		}else if(dataSheet.getRow(rowIndex).getCell(colIndex).getCellTypeEnum()==CellType.NUMERIC){
			return String.valueOf(dataSheet.getRow(rowIndex).getCell(colIndex).getNumericCellValue());
		}
		
		return "";
	}
	public String[][] getData(){
		
	int totalRows = totalRows();
	int totalCol = maxColInRow();
	String[][] data = new String[totalRows][totalCol];
	
	System.out.println(totalRows);
		for(int i=0;i<totalRows;i++){
			
			for(int j=0;j<totalCol;j++){
				try{
				
					data[i][j]=getData(i+1, j);
				}catch(NullPointerException ne){
				
				}
			}
			//Row row = dataSheet.getRow(i);
		}
		
		return data;
		
	}
	
	public Map<String, String> getDataMap(){
		
		int totalRows = totalRows();
		int totalCol = maxColInRow();
		Map<String, String> data = new HashMap<String, String>();
		
		System.out.println(totalRows);
			for(int i=0;i<totalRows;i++){
				
				for(int j=0;j<totalCol;j++){
					try{
						data.put(getData(0,j), getData(i+1,j));
						//data[i][j]=getData(i+1, j);
					}catch(NullPointerException ne){
					
					}
				}
				//Row row = dataSheet.getRow(i);
			}
			System.out.println(data);
			return data;
			
		}
	
	
	
}

