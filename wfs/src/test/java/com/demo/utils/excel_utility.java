package com.demo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_utility {

	public FileInputStream fileIP;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path;
	
	public excel_utility(String path) {
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException {
		fileIP=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileIP);
		sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		fileIP.close();
		return rowCount;
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException {
		fileIP=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileIP);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fileIP.close();
		return cellCount;
	}
	
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
		fileIP=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileIP);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter=new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);
		}
		catch(Exception e) {
			data="";
			
		}
		workbook.close();
		fileIP.close();
		return data;
	}
	
	public Object[][] array(String sheet) throws IOException{
		int rownum=getRowCount(sheet);
		int cellnum=getCellCount(sheet,1);
	Object data[][]=new String[rownum][cellnum];
	for(int i=1;i<rownum;i++)
	{
		for(int j=0;j<cellnum;j++) {
			data[i-1][j]=getCellData(sheet,i,j);
		}
	}
	return data;
	}
	
}
