package com.seleniumtutorial.org;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertPractise {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='Alert']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//input[@value='Confirmation Box']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//input[@value='Prompt']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Lokesh");
		alert.accept();
		driver.findElement(By.xpath("//input[@name='upload']")).sendKeys("C:\\Users\\Lokesh\\Desktop");
		
		TakesScreenshot sh =(TakesScreenshot) driver;
		File src = sh.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\ScreenShot\\screem.png");
		FileUtils.copyFile(src, des);
		
		WebElement mouse = driver.findElement(By.xpath("//button[@id='sub-menu']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(mouse).build().perform();;
		driver.findElement(By.xpath("//a[@id='link2']")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		
		
		
		
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		WebElement doubleClick = driver.findElement(By.xpath("//input[@value='Double Click Me']"));
		ac.contextClick(doubleClick);
		
		
		driver.quit();
		
		
		
		
		

		
		
		

	}

}
