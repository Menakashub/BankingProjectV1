package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name ="uid")WebElement txtusername;

	@FindBy(name ="password")WebElement txtpassword;

	@FindBy(name="btnLogin")WebElement loginbutton;
	
	@FindBy(linkText ="Log out")WebElement logout;

	public void setTxtusername(String uname) {
		txtusername.sendKeys(uname);
	}
	
	public void setTxtpassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginbutton.click();
	}
	
	public void clicklogout() {
		logout.click();
	}





}
