package com.ea.Framework.base;
/*
 * This Class Contains method to Initialize the framework with Different Browser and GRID
 * This class needs to be called with the respective methods to invoke browser instance
 */
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FrameWorkInitialize extends Base {
	
    public void InitializeBrowser(BrowserType browserType) throws MalformedURLException {
        RemoteWebDriver driver = null;
       
        {
            switch (browserType) {

                case Chrome: {
                    driver = new ChromeDriver();
                    break;
                }
                case FireFox: {
                	System.setProperty("webdriver.gecko.driver", "C:\\Users\\bisrout\\Documents\\Selenium\\geckodriver.exe");                                   	        
                    driver = new FirefoxDriver();
                    LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                    break;
                }
                //Use this only when Parallel execution is needed
                case Grid: {
                	System.setProperty("webdriver.gecko.driver", "C:\\Users\\bisrout\\Documents\\Selenium\\geckodriver.exe");
                	DesiredCapabilities cap = new DesiredCapabilities().firefox();                    
                    driver = new  RemoteWebDriver(new URL("http://192.168.0.4:4444/wd/hub"),cap);
                    LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                    break;
                }
                
                case IE: {
                    driver = new InternetExplorerDriver();
                    break;
                }
            }
            //Set Driver
            //DriverContext.setDriver(driver);
            //Browser
            //DriverContext.Browser = new Browser(driver);
        }
    }
}
