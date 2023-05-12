package com.ActiTime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// Declaration
	
	@FindBy (xpath="//div[.='Tasks']")
	private WebElement tasktab;
	
	
	@FindBy (xpath="//div[.='Reports']")	
	private WebElement reporttab;

	@FindBy (xpath="div[.='Users']")	
	private WebElement usertab;
	
	@FindBy(id="logoutLink")
	private WebElement lgloutlink;

 
 //Initialization

	public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}


	public WebElement getTasktab() {
		return tasktab;
	}


	public WebElement getReporttab() {
		return reporttab;
	}


	public WebElement getUsertab() {
		return usertab;
	}


	public WebElement getLgloutlink() {
		return lgloutlink;
	}}
	//utilize
	
