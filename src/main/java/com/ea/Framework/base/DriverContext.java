package com.ea.Framework.base;
/*
 *This Package has implementation of Driver utilities 
 *Any further addition to this will reflect in the Driver Instance
 *User can Add 
 */

import com.ea.Framework.Config.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverContext{
    
	//Desired URL navigation
	public static void GoToUrl(String url)
	{
		LocalDriverContext.getRemoteWebDriverLocal().get(url);
	}

    //Driver will wait for all the element of the page to Load
    public static void WaitForPageToLoad()
    {
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriverLocal(),30);
        JavascriptExecutor jsExecuter = (JavascriptExecutor)LocalDriverContext.getRemoteWebDriverLocal();
        ExpectedCondition<Boolean> jsLoad = webDriver -> ((JavascriptExecutor)LocalDriverContext.getRemoteWebDriverLocal())
                .executeScript("return document.readyState").toString().equals("complete");
        //Get js Ready
        boolean jsReady = jsExecuter.executeScript("return document.readyState").toString().equals("complete");
        if(!jsReady)
        {
            wait.until(jsLoad);
        }
        else
        {
            Settings.log.Write("Page is ready");
        }
    }

    //Driver will wait for the specific element to be visible
    public static void WaitForElementVisible(final WebElement elementFindBy)
    {
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriverLocal(),30);
        wait.until(ExpectedConditions.visibilityOf(elementFindBy));

    }
    //Driver will wait for the specific text to be visible
    public static void WaitForElementTextVisible(final WebElement elementFindBy,String text)
    {
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriverLocal(),30);
        wait.until(ExpectedConditions.textToBePresentInElement(elementFindBy,text));

    }
  //Driver will wait for the specific text to be visible
    public static void WaitForElementTextDisplayed(final By elementFindBy,String text)
    {
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriverLocal(), 30);
        wait.until(textDisplayed(elementFindBy, text));

    }
  //Implemented in WaitForElementTextDisplayed method
    private static ExpectedCondition<Boolean> textDisplayed(final By elementFindBy, final String text)
    {
        return webDriver -> webDriver.findElement(elementFindBy).getText().contains(text);
    }
    
    public static void waitFortheElementEnabled (final By elementFindBy)
    {
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriverLocal(), 30);
        wait.until(webDriver -> webDriver.findElement(elementFindBy).isEnabled());
    }
}
