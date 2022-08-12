package com.td.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.td.PageActions.BaseActions;

public class PropFileHandler extends BaseActions
{
	public static Properties config = new Properties();
	
	static
	{
		try {
			FileInputStream configReader = new FileInputStream("src/test/resources/TestData/config.properties");
			try {
				config.load(configReader);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static String readProperty(String property)
	{
		return config.getProperty(property);
	}
}
