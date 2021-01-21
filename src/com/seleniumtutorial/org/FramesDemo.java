package com.seleniumtutorial.org;

//import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		 WebElement singleFrame = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		 driver.switchTo().frame(singleFrame);
		 driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Lokesh");
		 driver.switchTo().defaultContent();
		 driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
		 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Lokesh");
		 Thread.sleep(2000);
		 driver.switchTo().defaultContent();
		 driver.quit();
		
		
		
		 driver.quit();
	}
}
