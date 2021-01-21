package com.seleniumtutorial.org;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Converter;

public class WindowsHandling {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\Lokesh\\\\eclipse-workspace\\\\SeleniumTutorial\\\\Drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		String parentWindow = driver.getWindowHandle();
		Set<String> childWindows = driver.getWindowHandles();
		int noOfWindows = childWindows.size();
		System.out.println(noOfWindows);
		System.out.println(parentWindow);
		String titleOfParentWindows = driver.getTitle();
		System.out.println(titleOfParentWindows);
		for(String child : childWindows)
		{
			if(!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				Thread.sleep(2000);
				String childWindowID = driver.getWindowHandle();
				System.out.println(childWindowID);
				String titleOfChild = driver.getTitle();
				System.out.println(titleOfChild);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		
		TakesScreenshot shi =(TakesScreenshot) driver;
		File src = shi.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\ScreenShot");
		FileUtils.copyFile(src, des);
		
		
		

		driver.quit(); 
		
		
		

	}

}
