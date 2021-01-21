package com.seleniumtutorial.org;

import java.awt.image.ReplicateScaleFilter;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {
	public static void main(String[] args) {
		String s= "1000";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		Actions ac = new Actions(driver);
		WebElement men = driver.findElement(By.xpath("//a[@data-group='men']"));
		ac.moveToElement(men).build().perform();
		driver.findElement(By.xpath("//a[text()='Casual Shirts']")).click();
		System.out.println(driver.getTitle());
		List<WebElement> price = driver.findElements(By.xpath("//h4[text()='Men Slim Fit Casual Shirt']//parent::div//div//span/span[@class='product-discountedPrice']"));
		System.out.println(price.size());
		List<Integer> li = new ArrayList<Integer>();
		for (WebElement st : price) 
		{
			
		String text = st.getText();
		String replace = text.replace("Rs. ","");
		String trim = replace.trim();
		System.out.println(trim);
		int parseInt = Integer.parseInt(trim);
		li.add(parseInt);
		}
		
		
		System.out.println(li);
		System.out.println("the higest price is :"+   Collections.max(li));
		
		driver.quit();

	}

}
