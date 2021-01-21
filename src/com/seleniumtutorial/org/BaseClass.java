package com.seleniumtutorial.org;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Default;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver getBrowser(String browsername) {

		try {
			if (browsername.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browsername.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else {
				System.out.println("enter the correct browser name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;

	}

	public static void gettingUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void sendingText(String xpath, String text) {
		try {
			driver.findElement(By.xpath(xpath)).sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enterClick() {
		try {
			Actions ac = new Actions(driver);
			ac.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickingText(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void dateOfBirth(WebElement element, String value, String option) {
		try {
			Select sc = new Select(element);
			if (option.equalsIgnoreCase("value")) {
				sc.selectByValue(value);
			}
			else if (option.equalsIgnoreCase("text")) {
				sc.selectByVisibleText(value);
			}
			else if (option.equalsIgnoreCase("int")) {
				sc.selectByIndex(Integer.parseInt(value));
			}
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}
	}
	public static void explitWait(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void screenShot(String screencspture) {
		try {
			TakesScreenshot sc = (TakesScreenshot) driver;
			File src = sc.getScreenshotAs(OutputType.FILE);
			File des= new File("C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\ScreenShot"+screencspture);
			FileUtils.copyFile(src, des);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void mouseOverTheElement(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element);

	}

}
