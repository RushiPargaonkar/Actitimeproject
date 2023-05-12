package com.ActiTime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {

	//Decl
	@FindBy(xpath="//div[.='Add new'")
	private WebElement addnewbtn;
	
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement newcust;
	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custname;
	
	
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement custdesp;
	

	@FindBy(xpath="//div[@class='greyButton cancelBtn']")
	private WebElement cancelbtn;
	
	
	
	
	//initiallization
	
	public TaskPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	
	//utillization
	
	public WebElement getAddnewbtn() {
		return addnewbtn;
	}

	public WebElement getNewcust() {
		return newcust;
	}

	public WebElement getCustname() {
		return custname;
	}

	public WebElement getCustdesp() {
		return custdesp;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}
	
	
	
}
////div[.='+ New Customer']
//(//input[@placeholder='Enter Customer Name'])[2]

////textarea[@placeholder='Enter Customer Description']

