package com.seleniumtutorial.org;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenLinkDemo2 {
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> imageLinks = driver.findElements(By.tagName("img"));
		int size = imageLinks.size();
		System.out.println(size);
		List<WebElement> actualImageLinks = new ArrayList<WebElement>();
		for(int a=0;a<size;a++) {
			if(imageLinks.get(0).getAttribute("src")!= null) {
				actualImageLinks.add(imageLinks.get(a));
			}
		}
		int size2 = actualImageLinks.size();
		System.out.println(size2);
		for(int b=0;b<size2;b++) {
			HttpURLConnection openConnection = (HttpURLConnection) new URL(actualImageLinks.get(b).getAttribute("src")).openConnection();
			openConnection.connect();
			String responseMessage = openConnection.getResponseMessage();
			openConnection.disconnect();
			System.out.println(actualImageLinks.get(b).getAttribute("src")+"----->"+responseMessage);
		}
		
		System.out.println("The End");
		
		driver.quit();
		
		
	}
}
