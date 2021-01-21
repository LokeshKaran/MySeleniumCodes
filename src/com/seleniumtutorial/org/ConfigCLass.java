package com.seleniumtutorial.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigCLass {
	public Properties prop;
	public ConfigCLass() throws Exception {
		prop = new Properties();
		File f = new File("C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\src\\com\\seleniumtutorial\\org\\config.properties");
		FileInputStream ip = new FileInputStream(f);
		prop.load(ip);
	}
	public static void main(String[] args) throws Exception {
		ConfigCLass c = new ConfigCLass();
		System.out.println(c.prop.getProperty("firstname"));
	}

}
