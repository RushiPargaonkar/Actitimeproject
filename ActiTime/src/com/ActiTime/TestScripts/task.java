package com.ActiTime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ActiTime.GenericLibrary.Baseclass;
import com.ActiTime.GenericLibrary.Filelibrary;
import com.ActiTime.ObjectRepository.HomePage;
import com.ActiTime.ObjectRepository.TaskPage;

public class task extends Baseclass{

	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException
	{
		HomePage hp = new HomePage(driver);
		hp.getTasktab().click();
		TaskPage tp = new TaskPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcust().click();
		
		Filelibrary f= new Filelibrary();
	String createcustmor = f.readDataFromExcel("Sheet1", 1, 1);
		
	tp.getCustname().sendKeys(createcustmor);
	String description = f.readDataFromExcel("Sheet1", 1, 2);
	tp.getCustdesp().sendKeys(description);
	
	
	
	tp.getNewcust().click();
	String expectedresult = createcustmor;
	
	 String Actualresult = driver.findElement(By.xpath("(//div[.='Praju'])[2]")).getText();
	
	SoftAssert s= new SoftAssert();
	s.assertEquals(Actualresult, expectedresult);
	s.assertAll(); 
	
		
	}
}
