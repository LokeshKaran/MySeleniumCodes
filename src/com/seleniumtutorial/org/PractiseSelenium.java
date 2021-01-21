package com.seleniumtutorial.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PractiseSelenium {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.greenstechnologys.com/contact.php");
		driver.manage().window().maximize();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='InputName']"));
		firstName.sendKeys("Lokesh");
		System.out.println(firstName.getAttribute("value"));
		System.out.println(firstName.getAttribute("id"));
		driver.findElement(By.xpath("(//input[contains(@placeholder,'Email')])[1]")).sendKeys("lokeshkaran01@gmail.com");
		WebElement texting = driver.findElement(By.xpath("(//a[contains(text(),'contact@greenstechnologys.com')])[1]"));
		String text = texting.getText();
		System.out.println(texting.getAttribute("value"));
		System.out.println(text);
		driver.quit();
		
	}

}
