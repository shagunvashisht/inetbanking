package com.inetbanking.testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPage;
import com.inetbanking.utilities.xlsutils;

import junit.framework.Assert;

public class TC_LoginPage_test_ddt extends BaseClass {
	
@Test(dataProvider="logintest")
	
   public void loginTestDdt(String uname,String pwd) throws InterruptedException{
	LoginPage lp=new LoginPage(driver);
	//lp.setUsername(username1);
	lp.setUsername(uname);
	logger.info("Username is entered");
	//lp.setPassword(password1);
	lp.setPassword(pwd);
	logger.info("password is entered");
	lp.clickSubmit();
	logger.info("submitted");
	Thread.sleep(5000);
	
	if(isAlert()==true) {
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
	}
	else {
		Assert.assertTrue(true);
		lp.clickLogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
}
	
	
	public boolean isAlert() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e){
			return false;
		}
	
	}
	
	


@DataProvider(name="logintest")
	String[][] getdata() throws IOException{
	String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/LoginData.xlsx";
	
	int row= xlsutils.getRowCount(path, "Sheet1");
	int col=xlsutils.getCellCount(path, "Sheet1", 1);
	String logindata[][]=new String[row][col];
	for(int i=1;i<=row;i++) {
		for(int j=0;j<col;j++) {
			logindata[i-1][j]=xlsutils.getCellData(path, "Sheet1", i, j);
		}
	}
	return logindata;
	
}
}

