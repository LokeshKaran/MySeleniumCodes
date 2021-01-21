package com.seleniumtutorial.org;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksDemo {
	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://stackoverflow.com/questions/43389340/how-to-find-broken-images-for-an-entire-web-site-in-selenium-webdriver-using-jav");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> linksInPage = driver.findElements(By.tagName("a"));
		int size = linksInPage.size();
		System.out.println(size);
		
		List<WebElement> actualLinks = new ArrayList<WebElement>();
		for(int a=0;a<size;a++) {
		//	System.out.println(linksInPage.get(a).getAttribute("href"));
			if(linksInPage.get(a).getAttribute("href")!= null && (!linksInPage.get(a).getAttribute("href").contains("javascript")))
			{
				 actualLinks.add(linksInPage.get(a));
			}
	}
		int size2 = actualLinks.size();
		System.out.println(size2);
		
		for(int b=0;b<size2;b++) {
			 HttpURLConnection openConnection = (HttpURLConnection) new URL(actualLinks.get(b).getAttribute("href")).openConnection();
			 
			 openConnection.connect();
			 String activeLinkResponse = openConnection.getResponseMessage();
			 openConnection.disconnect();
			 System.out.println(actualLinks.get(b).getAttribute("href")+"----->"+activeLinkResponse);
		}
		
		
		
		System.out.println("The end ");
		driver.quit();
	}

}
