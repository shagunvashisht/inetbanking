package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	WebElement btnclick;
	
	@FindBy(linkText="Log out")
	WebElement lgoutbtn;
	
	public void setUsername(String Uname) {
		txtUserName.sendKeys(Uname);
	}

	public void setPassword(String passwd) {
		txtpassword.sendKeys(passwd);
	}
		
    public void clickSubmit( ) {
			btnclick.click();
			}
    
 public void clickLogout( ) {
					lgoutbtn.click();
			
	
 }
}
