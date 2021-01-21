package com.seleniumtutorial.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AutomationPractise2 extends BaseClass {
	public static void main(String[] args) {
		getBrowser("chrome");
		gettingUrl("http://automationpractice.com/index.php");
		WebElement mouse = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		mouseOverTheElement(mouse);
		clickingText("//a[@title='Faded Short Sleeve T-shirts']");
		
	}

}
