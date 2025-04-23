package com.genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of generic method
 * @author Pritesh
 */


public class FileUtility {
	
	/**
	 * This methods will read data from property file and excel file for the key provided by 
	 * the caller method and return the value to caller method
	 * 
	 * @param 
	 * @return
	 * @throws
	 * 
	 * 
	 */
	
	public static String readDataFromPropertyFile(String key) throws IOException 
	{//C:\\Users\\Pritesh\\Downloads\\Selenium.properties
		FileInputStream fis=new FileInputStream("D:\\Eclipse\\AutiomationFramework\\src\\test\\resources\\CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
	
	public static String readDataFromExcelFile(String sheetname, int rowNo, int cellNo) throws EncryptedDocumentException, IOException 
	{
		FileInputStream excelfile=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook wb=WorkbookFactory.create(excelfile);
		String value = wb.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}

}














