package com.hybridframework.module01.utility;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	public Properties prop;

	public ConfigDataProvider(String configdatapath) {
		try {
			File fs = new File(configdatapath);
			FileInputStream fins = new FileInputStream(fs);
			prop = new Properties();
			prop.load(fins);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("If file not found :" + e);
		}
	}

	public String searchkey(String key) {
		return prop.getProperty(key);

	}

	public String getUsername() {
		return prop.getProperty("username");

	}

	public String getPassword() {
		return prop.getProperty("password");

	}

	public String geturl() {
		return prop.getProperty("url");

	}
}
