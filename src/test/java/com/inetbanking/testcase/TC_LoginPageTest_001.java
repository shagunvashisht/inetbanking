package com.inetbanking.testcase;

import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPage;

public class TC_LoginPageTest_001 extends BaseClass{


@Test
	public void loginTest() {
	LoginPage lp=new LoginPage(driver);
	lp.setUsername(username1);
	logger.info("Username is entered");
	lp.setPassword(password1);
	logger.info("password is entered");
	lp.clickSubmit();
	logger.info("submitted");
	logger.info("demo");
}
}
