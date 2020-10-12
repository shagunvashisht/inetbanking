package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		try {
			pro=new Properties();
			File src=new File("./Configuration/Config.properties");
			FileInputStream fis= new FileInputStream(src);
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exeception is found");
			
		}
	}
	public String getApplicationURL() {
		String url=pro.getProperty("baseurl");
		return url;
	}
	public String getusername(){
		String name=pro.getProperty("username");
		return name;
		}
		
	public String getpassword(){
			String passwrd=pro.getProperty("password");
			return passwrd;
			}
	
	public String chromedriver(){
				String cdriver=pro.getProperty("chromedriver");
				return cdriver;
			}
	public String iedriver(){
		String iedriver=pro.getProperty("iedriver");
		return iedriver;
	}
		
		
	}
