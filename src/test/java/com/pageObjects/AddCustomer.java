package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	WebDriver ldriver;

	public AddCustomer(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText ="New Customer")WebElement NewCustomerlink;
	@FindBy(name="name")WebElement Custname;
	@FindBy(name="rad1")WebElement Gender;
	@FindBy(name="dob")WebElement dob;
	@FindBy(name="addr")WebElement Address;
	@FindBy(name="city")WebElement city;
	@FindBy(name="state")WebElement state;
	@FindBy(name="pinno")WebElement pinno;
	@FindBy(name="telephoneno")WebElement telephoneno;
	@FindBy(name="sub")WebElement Submit;
	@FindBy(name="res")WebElement Reset;
	@FindBy(name="emailid")WebElement emailid;
	@FindBy(name="password")WebElement password;




	//Writing actions for WebElements

	public void clicknewcustomerlink() {
		NewCustomerlink.click();
	}
	public void Custname(String cname) {
		Custname.sendKeys(cname);
	}
	public void Gender(String cgender) {
		Gender.click();

	}
	public void dob(String mm,String dd, String yy) {
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yy);
	}
	public void Address(String cAddress) {
		Address.sendKeys(cAddress);
	}
	public void city(String ccity) {
		city.sendKeys(ccity);
	}
	public void state(String cstate) {
		state.sendKeys(cstate);
	}
	public void pinno(int cpinno) {
		pinno.sendKeys(String.valueOf(cpinno)); //convert int to String ,as sendkeys will not accept int values
	}
	public void telephoneno(int ctelephoneno) {
		telephoneno.sendKeys(String.valueOf(ctelephoneno));
	}
	public void emailid(String cemailid) {
		emailid.clear();
		emailid.sendKeys(cemailid);
	}
	public void password(String cpassword) {
		password.clear();
		password.sendKeys(cpassword);
	}
	public void clickSubmit() {
		Submit.click();
	}
	public void clickReset() {
		Reset.click();
	}
}
