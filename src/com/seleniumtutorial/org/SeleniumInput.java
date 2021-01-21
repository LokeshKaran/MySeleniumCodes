package com.seleniumtutorial.org;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Text;

public class SeleniumInput {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String title = driver.getTitle();
		WebElement findElement = driver.findElement(By.id("email"));
		findElement.sendKeys("Mumbai");
		System.out.println(findElement.getAttribute("value"));
		System.out.println(findElement.getAttribute("aria-label"));
		// findElement.
		// driver.close();
		WebElement findElement2 = driver.findElement(By.id("pass"));
		findElement2.sendKeys("Chennai");
		WebElement findElement3 = driver.findElement(By.xpath("//button[contains(@name,'login')]"));
		System.out.println(findElement3.getText());
		WebElement findElement4 = driver.findElement(By.xpath("//h2[contains(text(),'Facebook ')]"));
		String text = findElement4.getText();
		System.out.println(text);
		System.out.println(text.length());
		ArrayList<Object> it = new ArrayList<Object>();
		it.add(text);
		String[] split = text.split(" ");
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
		}
		System.out.println(it);

		WebElement LinkToClick = driver.findElement(By.xpath("//a[@role='button' and @id='u_0_2']"));
		LinkToClick.click();
		System.out.println(driver.getTitle());
		boolean equals = LinkToClick.equals(title);
		System.out.println(equals);

		// driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		driver.close();

	}

}
