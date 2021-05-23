package com.test.mayurThapan.utills;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertyReader {

	public static Properties prp;
	
	public static String getProperty(String propertyValue) throws IOException
	{
		prp=new Properties();
		File f=new File("global.properties");
		FileInputStream fis=new FileInputStream(f.getAbsolutePath());
		prp.load(fis);
		return prp.getProperty(propertyValue);
	}
	
}
