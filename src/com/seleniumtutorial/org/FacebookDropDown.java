package com.seleniumtutorial.org;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookDropDown {
	public static void main(String[] args) throws InterruptedException, Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.sendKeys("Lokesh");
		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lastName.sendKeys("Karan");
		driver.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("34567973434");
		driver.findElement(By.xpath("//input[@type='text' and @id='dateOfBirthInput']")).click();
		String birthMonth ="August";
		String birthYear = "1994";
		WebElement month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		selMonth(month , birthMonth);
		Thread.sleep(2000);
		WebElement year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		selYear(year,birthYear);
		Thread.sleep(2000);
	}
	public static void selMonth(WebElement elm ,String mm) {
		Select sl = new Select(elm);
		sl.deselectByVisibleText(mm);

	}
	public static void selYear(WebElement elem , String yy) {
		Select s2 = new Select(elem);
		s2.selectByVisibleText(yy);

	}

}
