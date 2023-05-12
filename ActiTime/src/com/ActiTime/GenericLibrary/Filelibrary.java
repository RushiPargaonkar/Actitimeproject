package com.ActiTime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Filelibrary 
{
	/**
	 * This is a generic method which is used to read the data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
 public String readDataFromPropertyFile(String key) throws IOException
 {
	 FileInputStream fis = new FileInputStream ("./TestData/command.property.txt");
	 Properties p = new Properties();
	 p.load(fis);
	 String  value = p.getProperty(key);
	 return value;
 }
 
 /**
  * This is a generic method which is used to read the data from Excel file.
  * @param sheetname
  * @param row
  * @param cell
  * @return
  * @throws EncryptedDocumentException
  * @throws IOException
  */
   public String readDataFromExcel(String sheetname , int row , int cell ) throws EncryptedDocumentException, IOException
   {
	   FileInputStream fis1 = new FileInputStream("./TestData/TESTDATA.xlsx");
	   Workbook wb = WorkbookFactory.create(fis1);
	   String value =wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	   return value;
	   
   }
}
