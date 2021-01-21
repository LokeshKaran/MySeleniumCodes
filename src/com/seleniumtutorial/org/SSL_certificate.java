package com.seleniumtutorial.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSL_certificate {

	public static void main(String[] args) {
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		the Desiredcapablitiesis deprisiated.
		
		ChromeOptions cape = new ChromeOptions();
		cape.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lokesh\\eclipse-workspace\\SeleniumTutorial\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(cape);
		driver.get("https://www.cacert.org/");

	}

}
