package com.seleniumtutorial.org;

import java.awt.SecondaryLoop;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class ExplicityWaitDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		WebElement buttonToClick = driver.findElement(By.xpath("//button[text()='Enable button after 10 seconds']"));
		buttonToClick.click();
		WebElement visibleButton = driver.findElement(By.xpath("//button[@id='disable']"));
		
		WebDriverWait waiting = new WebDriverWait(driver, 12);
		waiting.until(ExpectedConditions.elementToBeClickable(visibleButton));
		visibleButton.click(); 
		
		
		boolean enabled = visibleButton.isEnabled();
		System.out.println(enabled);
		
		
		
					
		driver.quit();
	}

}
