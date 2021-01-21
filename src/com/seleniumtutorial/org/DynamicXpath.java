package com.seleniumtutorial.org;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/deals-jun2020?f=Categories%3AWatches&rf=Discount%20Range%3A70.0_100.0_70.0%20TO%20100.0");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		List<WebElement> watchPrice = driver.findElements(By.xpath("//h4[text()='Men Analogue Watch']//parent::div//div[@class='product-price']//span//span[@class='product-discountedPrice']"));
		List<Integer> li = new ArrayList<Integer>();
		
		System.out.println(watchPrice.size());
		for (WebElement price : watchPrice) {
			String text = price.getText();
			System.out.println(text);
			String replace = text.replace("Rs. ", "");
			int priceInInteger = Integer.parseInt(replace);
			li.add(priceInInteger);
			
		}
		System.out.println(li);
		System.out.println("the maximun price of the watch is"+Collections.max(li));
		System.out.println("the minimum price of the watch is "+Collections.min(li));
		int b=0;
		for(int a=0;a<li.size();a++) {
			if(li.get(a)==(989)) {
				++b;
				
			}
		}
		System.out.println("the price of 989 come "+b+" times");
		driver.quit();
		 
	}

}
