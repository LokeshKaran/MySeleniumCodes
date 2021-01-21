package com.seleniumtutorial.org;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPractiseDemo extends ConfigCLass {
	public AutomationPractiseDemo() throws Exception {
		super();
	}
	public static void main(String[] args) throws Exception {
		ConfigCLass c = new ConfigCLass();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign')]")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(c.prop.getProperty("emailId"));
		driver.findElement(By.xpath("//i[contains(@class,'icon-user left')]")).click();
		
		String firstName=c.prop.getProperty("firstname");
		String lastName=c.prop.getProperty("lastname");
		
		
		
		clickingMethod(driver, "(//input[@name='id_gender'])[1]");
		
		
		typingMethod(driver, "//input[@id='customer_firstname']", firstName);
		
		typingMethod(driver, "//input[@id='customer_lastname']", lastName);
		
		typingMethod(driver, "//input[@id='passwd']", "Lokeshkaran27..");
		Thread.sleep(10000);
		Select sc1= new Select(driver.findElement(By.xpath("//Select[@id='days']")));
		sc1.selectByValue("27");
		selectingText(driver.findElement(By.xpath("//Select[@id='months']")), "August ");
		Select sc2 = new Select(driver.findElement(By.xpath("//Select[@id='years']")));
		sc2.selectByValue("1994");
		
		typingMethod(driver, "//input[@id='firstname']", firstName);
		typingMethod(driver, "//input[@id='lastname']", lastName);
		typingMethod(driver, "//input[@id='address1']", "2/42,Pilliyar kovil street");
		typingMethod(driver, "//input[@id='city']", "Chennai");
		selectingText(driver.findElement(By.xpath("//Select[@id='id_state']")), "Indiana");
		typingMethod(driver, "//Input[@id='postcode']", "60310");
		selectingText(driver.findElement(By.xpath("//Select[@id='id_country']")), "United States");
		typingMethod(driver, "//Input[@id='phone_mobile']", "7708874917");
		driver.findElement(By.xpath("//Input[@id='alias']")).clear();
		driver.findElement(By.xpath("//Input[@id='alias']")).sendKeys("same Address");
		clickingMethod(driver, "//button[@id='submitAccount']//span");
		
	}
	public static void clickingMethod(WebDriver driver, String ss) {
		driver.findElement(By.xpath(ss)).click();
	}
	public static void typingMethod(WebDriver driver , String sa,String typing) {
		driver.findElement(By.xpath(sa)).sendKeys(typing);
	}
	public static void selectingText(WebElement element,String visible) {
		Select sc = new Select(element);
		sc.selectByVisibleText(visible);
	}
}
