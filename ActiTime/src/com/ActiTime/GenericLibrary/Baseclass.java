package com.ActiTime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ActiTime.ObjectRepository.HomePage;
import com.ActiTime.ObjectRepository.LoginPage;

public class Baseclass {
	
	
		
		public static WebDriver driver;
		Filelibrary f = new Filelibrary(); // Getting data from file library From Base class
		
		
		@BeforeSuite                          // Database Conection
		public void databaseconnection()
		
		{
			Reporter.log("database connected",true);
		}
		
		@BeforeClass           //   use To Perform  / Lauunch browser
		
		public void LaunchBrowser() throws IOException
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			 String URL = f.readDataFromPropertyFile("url");  //Read data from ProperTy file
			
			driver.get(URL);
			Reporter.log("Browser Launch",true);
			
		}
		
		@BeforeMethod                      // used to Locate elements write in @beforemethod
		
		public void login () throws IOException
		{
			// Use For Read Data From FileLibrary Class
			
//			String UN = f.readDataFromPropertyFile("username");
//			driver.findElement(By.name("username")).sendKeys(UN);
//			
//			String PW = f.readDataFromPropertyFile("password");
//			driver.findElement(By.name("username")).sendKeys(PW);
//			
//			driver.findElement(By.xpath("//div[.='Login ']")).click();	
			
			
			LoginPage lp = new LoginPage(driver);
			String UN = f.readDataFromPropertyFile("username");
			String PW = f.readDataFromPropertyFile("password");
			lp.getUntbx().sendKeys(UN);
			lp.getPwtbx().sendKeys(PW);
			lp.getUntbx().click();
		
//			// Use For Enter Data From LoginPage Class
//			LoginPage lp = new LoginPage(driver);
//			lp.getUntbx().sendKeys("admin");
//			lp.getPwtbx().sendKeys("manager");
//			lp.getUntbx().click();
			
			Reporter.log("Login Succsessfully ",true);
		}
		
		@AfterMethod                   //  used to end 
		public void logout()
		{
		//	driver.findElement(By.id("logoutLink")).click();
			
			HomePage hp = new HomePage(driver);
			hp.getLgloutlink().click();
			Reporter.log("Logout successfully",true);
		}
		 
		@AfterClass    // used to  
		public void closebrowser()
		{
			driver.close();
			Reporter.log("Browser closed",true);
		}
		
		@AfterSuite
		public void databasedisconnection()
		{
			Reporter.log("database Disconnected",true);
		}
		
}
// ListnerImplementation  it is a class which is having some overriden methods in it to call this overriden mehod we need ItestListner

	


