package com.google.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	public static WebDriver driver;

	static List<String> browserList = new ArrayList<String>();

	static {
		browserList.add("chrome");
	}

	@Test(priority = 1)
	public void loginTest() throws Throwable {
		for (String browser : browserList) {
			
			  String url = "http://172.21.0.2:4444/wd/hub";
			  //String url = "http://172.24.130.93:4444/wd/hub"; 
			  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			  desiredCapabilities.setBrowserName(browser);
			  try { 
				  driver = new RemoteWebDriver((new URL(url)), desiredCapabilities); 
			  } catch (MalformedURLException e) { 
				  e.printStackTrace(); 
			  }
			 
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			System.out.println("Browser Opened");
			driver.findElement(By.name("q")).sendKeys("Zensar");
			System.out.println("Added zensat in the search box");
	    	driver.quit();
		}
	}
}
