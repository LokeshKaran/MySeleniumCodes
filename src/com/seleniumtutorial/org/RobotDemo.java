package com.seleniumtutorial.org;

import java.awt.AWTException; 
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RobotDemo {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Actions ac = new Actions(driver);

		WebElement rightClick1 = driver.findElement(By.xpath("//a[text()='Best Sellers']"));
		ac.contextClick(rightClick1).build().perform();
		callingRobot();

		WebElement rightClick2 = driver.findElement(By.xpath("//a[text()='Mobiles']"));
		ac.contextClick(rightClick2).build().perform();
		callingRobot();

		WebElement rightClick3 = driver.findElement(By.xpath("(//a[@class='nav-a  '])[3]"));
		ac.contextClick(rightClick3).build().perform();
		callingRobot();

		WebElement rightClick4 = driver
				.findElement(By.xpath("//span[text()='Hello, Sign in']//parent::div//parent::a"));
		ac.contextClick(rightClick4).build().perform();
		callingRobot();
		
		String logintitle="Amazon Sign In";
		String parentWindow = driver.getWindowHandle();
		Set<String> childWindows = driver.getWindowHandles();
		int childSize = childWindows.size();
		System.out.println("the number odchild windows :-->"+childSize);
		for (String cId : childWindows) {
			String childTitles = driver.switchTo().window(cId).getTitle();
			System.out.println(childTitles);
			if(childTitles.equals(logintitle)) {
				driver.switchTo().window(cId);
				break;
			}
		}
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Lokesh@gmail.com");
		Thread.sleep(3000);
		
		driver.quit();
	}

	public static void callingRobot() throws AWTException {

		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_DOWN);
		ro.keyRelease(KeyEvent.VK_DOWN);

		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);
		ro.setAutoDelay(3000);

	}
}
