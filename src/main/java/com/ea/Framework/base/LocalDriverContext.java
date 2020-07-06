package com.ea.Framework.base;
/*
 * This class is used with Selenium Remote Server as well as for Selenium Driver.
 * Below methods will be helpful for single and multi-threading operation
 */
import org.openqa.selenium.remote.RemoteWebDriver;

public class LocalDriverContext {
	
	private static ThreadLocal<RemoteWebDriver> remoteWebDriverThreadLocal = new ThreadLocal<>();
    //Get the driver instance from this method to start
	public static RemoteWebDriver getRemoteWebDriverLocal()
	{
		return remoteWebDriverThreadLocal.get();
	
	}
	
	static void setRemoteWebDriverThreadLocal(RemoteWebDriver driverThreadLocal)
	{
		remoteWebDriverThreadLocal.set(driverThreadLocal);
	}
}
