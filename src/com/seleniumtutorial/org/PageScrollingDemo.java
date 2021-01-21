package com.seleniumtutorial.org;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PageScrollingDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		/*	js.executeScript("window.scrollTo(200,300);");
		Thread.sleep(2000); */
		
		WebElement sendingText = driver.findElement(By.xpath("//input[@id='name']"));
		WebElement clicking = driver.findElement(By.xpath("//input[@id='alertbtn']"));
		js.executeScript("arguments[0].scrollIntoView();", clicking);
		js.executeScript("arguments[0].value='Lokesh';", sendingText);
		Thread.sleep(2000); 
		js.executeScript("arguments[0].click();", clicking);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		driver.quit();
		}
	}


