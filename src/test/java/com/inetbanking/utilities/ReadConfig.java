package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{ 
		try {
	
		FileInputStream fs = new FileInputStream("./Configuration/config.properties");
		pro=new Properties();
		pro.load(fs);
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
		
	}
	
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String pwd=pro.getProperty("password");
		return pwd;
	}
	public String getChromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}

}
