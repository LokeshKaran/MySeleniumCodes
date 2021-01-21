package com.seleniumtutorial.org;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver	= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions ac = new Actions(driver);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Lokesh");
		Thread.sleep(3000);
		ac.sendKeys(Keys.PAGE_DOWN).build().perform();
		ac.sendKeys(Keys.TAB).sendKeys("Karan").sendKeys(Keys.TAB).click().sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).click().build().perform(); 
		
		TakesScreenshot sh =(TakesScreenshot) driver;
		File src = sh.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\ScreenShot\\sample6.png");
		FileUtils.copyFile(src, des);
		
		Thread.sleep(2000);
		driver.quit();
	}

}
