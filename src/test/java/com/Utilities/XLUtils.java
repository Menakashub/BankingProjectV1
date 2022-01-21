package com.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fs;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell column;
	public static FileOutputStream fo;
	public static CellStyle style;


	public static int getRowCount(String filename , String Sheetname) throws IOException {
		System.out.println("I am in row count method");
		fs = new FileInputStream(filename);
		wb = new XSSFWorkbook(fs);
		sheet=wb.getSheet(Sheetname);
		int rowcount= sheet.getLastRowNum();
		wb.close();
		fs.close(); 
		return rowcount;
	}
	public static int getColCount(String filename , String Sheetname,int rownum) throws IOException {
		fs = new FileInputStream(filename);
		wb = new XSSFWorkbook(fs);
		sheet=wb.getSheet(Sheetname);
		row=sheet.getRow(rownum);
		int colcount=row.getLastCellNum();
		wb.close();
		fs.close();
		return colcount;
	}
	public static String getCellData(String filename,String Sheetname,int rownum , int colnum) throws IOException {
		String data = null;
		fs = new FileInputStream(filename);
		wb = new XSSFWorkbook(fs);
		sheet=wb.getSheet(Sheetname);
		row=sheet.getRow(rownum);
		column=row.getCell(colnum);
		DataFormatter format = new DataFormatter();
		
		try {
			data=format.formatCellValue(column);
		} catch (Exception e) {
			data="";
			e.printStackTrace();
		}
		wb.close();
		fs.close();
		return data;
		}
	public void setCellData(String filename,String Sheetname,int rownum , int colnum,String data ) throws IOException {
		fs = new FileInputStream(filename);
		wb = new XSSFWorkbook(fs);
		sheet=wb.getSheet(Sheetname);
		row=sheet.getRow(rownum);
		column=row.createCell(colnum);
		column.setCellValue(data);
		fo= new FileOutputStream(filename);
		wb.write(fo);
		wb.close();
		fs.close();
		fo.close();
		
	}
	
	public void fillGreenColor(String filename,String Sheetname,int rownum , int colnum) throws IOException {
		fs = new FileInputStream(filename);
		wb = new XSSFWorkbook(fs);
		sheet=wb.getSheet(Sheetname);
		row=sheet.getRow(rownum);
		column=row.getCell(colnum);
		style=wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		column.setCellStyle(style);
		wb.write(fo);
		wb.close();
		fs.close();
		fo.close();
		}
	public void fillRedColor(String filename,String Sheetname,int rownum , int colnum) throws IOException {
		fs = new FileInputStream(filename);
		wb = new XSSFWorkbook(fs);
		sheet=wb.getSheet(Sheetname);
		row=sheet.getRow(rownum);
		column=row.getCell(colnum);
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		column.setCellStyle(style);
		wb.write(fo);
		wb.close();
		fs.close();
		fo.close();
	}
		
}
