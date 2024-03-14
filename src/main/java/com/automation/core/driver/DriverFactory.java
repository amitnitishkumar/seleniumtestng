/**
 * 
 */
package com.automation.core.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class DriverFactory {

	private DriverFactory() {}
	public static WebDriver getDriver(String browser) throws MalformedURLException {

		WebDriver driver=null;

		if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver(BrowserCapability.chromeOptionsSupplier.get());
		}
		else if(browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver(BrowserCapability.fireFoxOptionsSupplier.get());
		}
		driver.manage().window().maximize();
		return driver;
	}

}
