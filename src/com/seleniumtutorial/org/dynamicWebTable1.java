package com.seleniumtutorial.org;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicWebTable1 {
	static int exactRow = 0;
	static int indexOfTotalCases = 0;
	static int indexOfActiveCases = 0;
	static String case1 = "New Deaths";
	static String case2 = "Active Cases";
	static String country = "Mexico";
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/coronavirus/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		List<WebElement> allHeaders = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']//thead//tr//th"));
		for (int i = 0; i < allHeaders.size(); i++) {
			String text = allHeaders.get(i).getText();
			String TextOfHeaders = text.replaceAll("\n", " ");
			if (TextOfHeaders.equalsIgnoreCase(case1)) {
				indexOfTotalCases = i - 1;
			}
			if (TextOfHeaders.equalsIgnoreCase(case2)) {
				indexOfActiveCases = i - 1;
			}
		}
		List<WebElement> noOfrows = driver.findElements(By.xpath(
				"	(//table[@id='main_table_countries_today']//tbody)[1]//tr[@class='odd']//td//a[@class='mt_a']"));
		for (int j = 0; j < noOfrows.size(); j++) {
			String text2 = noOfrows.get(j).getText();
			if (text2.equalsIgnoreCase(country)) {
				exactRow = j + 1;
				System.out.println("Corona Cases of :" + country);
				WebElement countryAndTotalCases = driver
						.findElement(By.xpath("(//table[@id='main_table_countries_today']//tbody)[1]//tr[@class='odd']["
								+ exactRow + "]//td//a[@class='mt_a']//parent::td//following-sibling::td["
								+ indexOfTotalCases + "]"));
				System.out.println("the Total coronacases in " + text2 + " is :" + countryAndTotalCases.getText());
				WebElement countryAndActiveCases = driver
						.findElement(By.xpath("(//table[@id='main_table_countries_today']//tbody)[1]//tr[@class='odd']["
								+ exactRow + "]//td//a[@class='mt_a']//parent::td//following-sibling::td["
								+ indexOfActiveCases + "]"));
				System.out.println("the Active coronacases in " + text2 + " is :" + countryAndActiveCases.getText());
			}

		}
		driver.quit();

	}

}