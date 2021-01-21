package com.seleniumtutorial.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocators {
	public static void main(String[] args) {
		try {
			loca();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void loca() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Faccounts.google.com%2FManageAccount%3Fnc%3D1&gmb=exp&biz=false&flowName=GlifWebSignIn&flowEntry=SignUp");
		driver.manage().window().maximize();

		/*
		 * driver.navigate().to("https://www.facebook.com/"); Thread.sleep(2000);
		 * driver.navigate().back(); Thread.sleep(2000); driver.navigate().forward();
		 * Thread.sleep(2000); driver.navigate().back(); Thread.sleep(2000);
		 * driver.navigate().refresh();
		 */
		WebElement firstname = driver.findElement(By.id("firstName"));
		firstname.sendKeys("Master");
		Thread.sleep(2000);
		WebElement lastname = driver.findElement(By.name("lastName"));
		lastname.sendKeys("Vijay");

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Lokeshkaran");
		WebElement passw = driver.findElement(By.xpath("(//input[contains(@type,'password')])[2]"));
		
		passw.sendKeys("password");
		System.out.println(passw.getAttribute("value"));
		passw.clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[contains(@type,'password')])[1]")).sendKeys("what are you doing");
		WebElement value = driver
				.findElement(By.xpath("(//div[contains(text(),'You can use letters, numbers & periods')])"));
		String text = value.getText();
	
		System.out.println(text);
		WebElement otherPage = driver.findElement(By.xpath("(//div[@class='VfPpkd-RLmnJb'])[3]"));
		String attribute = otherPage.getAttribute("value");
		System.out.println(attribute);
		otherPage.click();
		String title = driver.getTitle();
		System.out.println(title);

		driver.close();

	}

}
