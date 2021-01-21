package com.seleniumtutorial.org;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPractiseDemo1 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		clickingText( "//a[contains(text(),'Sign in')]");
		sendingText("//input[@id='email']", "lokeshkaran01@gmail.com");
		sendingText("//input[@id='passwd']", "Lokeshkaran27..");
		clickingText("(//span//i)[6]");
		Actions ac = new Actions(driver);
		WebElement mouseOver = driver.findElement(By.xpath("//a[text()='Women']"));
		ac.moveToElement(mouseOver).build().perform();
		clickingText( "(//a[text()='T-shirts'])[1]");
		WebElement dressMouseOver = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		ac.moveToElement(dressMouseOver).build().perform();
		clickingText("//span[text()='Quick view']");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']")));
		clickingText("//i[@class='icon-plus']");
		Select sc = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
		sc.selectByValue("2");
		clickingText("//a[@name='Blue']");
		clickingText("//span[text()='Add to cart']");	
		Thread.sleep(2000);
		clickingText("//a[@title='Proceed to checkout']");
		driver.switchTo().defaultContent();
		clickingText("(//a[@title='Proceed to checkout'])[2]");
		clickingText("//button[@name='processAddress']");
		clickingText("//input[@type='checkbox']");
		clickingText("//button[@name='processCarrier']");
		clickingText("//a[@title='Pay by bank wire']");
		WebElement scrolling = driver.findElement(By.xpath("//span[text()='I confirm my order']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrolling);
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\ScreenShot\\automation.png");
		FileUtils.copyFile(src, des);
		driver.quit();
		
	
	}
	public static void sendingText(String xpath ,String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	public static void clickingText(String xpath) {
		driver.findElement(By.xpath(xpath)).click();

	}


}
