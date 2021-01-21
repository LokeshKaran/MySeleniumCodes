package com.seleniumtutorial.org;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtilsCopyDirectoryToDirectoryTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.facebook.com/");
		List<WebElement> Linksin = driver.findElements(By.tagName("a"));
		System.out.println(Linksin.size());
		for(WebElement arr : Linksin) {
			System.out.println(arr);
		}
		TakesScreenshot sh = (TakesScreenshot) driver;
		File src = sh.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\ScreenShot\\Sample.png");
		FileUtils.copyFile(src, des);
				
	
		Thread.sleep(2000);
		
		driver.quit();
		
			
	}

}
