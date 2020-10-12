package com.inetbanking.testcase;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	public static WebDriver driver;
	ReadConfig rd=new ReadConfig();
	public String baseurl=rd.getApplicationURL();
	public String username1=rd.getusername();
	public String password1=rd.getpassword();
	public String chdriver=rd.chromedriver();
	public String intedriver=rd.iedriver();
	public static Logger logger;
	
@Parameters("Browser")
@BeforeClass
	public void setUp(String br) {
	if(br.equals("Chrome")) {
	System.setProperty("webdriver.chrome.driver", chdriver);
	ChromeOptions capability = new ChromeOptions();
	capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

	driver =new ChromeDriver(capability);
	}
	else if(br.equals("IE")) {
		System.setProperty("webdriver.ie.driver", intedriver);
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		driver=new InternetExplorerDriver(cap);
	}
	logger=Logger.getLogger("ebanking");
	DOMConfigurator.configure("log4j.xml");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(baseurl);
	
	
	}
@AfterClass
	public void tearDown() {
	driver.quit();
	//driver.close();
}

}
