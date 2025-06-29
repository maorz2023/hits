package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	 public static WebDriver driver;

	    public static void initializeDriver() {
	        if (driver == null) {
	        	WebDriverManager.chromedriver().setup();
	 	       	driver = new ChromeDriver();
	        }
	    }

	    public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
}
