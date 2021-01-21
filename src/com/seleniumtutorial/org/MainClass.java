package com.seleniumtutorial.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainClass extends BaseClass{
	public static void main(String[] args) throws InterruptedException {
		getBrowser("chrome");
		gettingUrl("https://www.facebook.com/");
		clickingText("//a[text()='Create New Account']");
		WebElement day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		explitWait(day);
		dateOfBirth(day, "27", "value");
		WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		dateOfBirth(month, "Aug", "text");
		dateOfBirth(year, "1994", "value");
		screenShot("\\screen.png");
		
		
		
		 quitBrowser();
	}

}
