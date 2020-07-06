package SeleniumTest;
/*
 * This will initialize the test with browser and close the execution also for each @Test
 */


import com.aventstack.extentreports.ExtentTest;
import com.cucumber.listener.Reporter;
import com.ea.Framework.Config.ConfigReader;
import com.ea.Framework.Config.Settings;

import com.ea.Framework.Utilities.DataBaseUtil;
import com.ea.Framework.Utilities.ExcelUtil;
import com.ea.Framework.Utilities.LogUtil;
import com.ea.Framework.Utilities.ReportingUtil;
import com.ea.Framework.base.BasePage;
import com.ea.Framework.base.BrowserType;
import com.ea.Framework.base.DriverContext;
import com.ea.Framework.base.FrameWorkInitialize;
import com.ea.Framework.base.LocalDriverContext;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import jxl.read.biff.BiffException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class TestInitialize extends FrameWorkInitialize {
    public ExcelUtil util;
    public Connection conn;
    

    @BeforeMethod
    //This will run before each @Test 
    public void Initialize() throws Exception {   
    	//Initializing Configuration properties
        ConfigReader.PopulateSettings();
        //Logging
        Settings.log = new LogUtil();
        Settings.log.CreateLogFile();
        Settings.log.Write("FrameWork Initialize");
        
        //Create Test cycle for reporting(Optional to the frame work can be removed)
        Settings.ReportingConnection =DataBaseUtil.Open(Settings.ReportingConnectionString);
        ReportingUtil.CreateTestCycle(DataBaseUtil.Open(Settings.ReportingConnectionString));
        
        //Only used for data base testing
        String statement ="SELECT * FROM Employees";
        try
        {
            DataBaseUtil.ExecuteQuery(statement,DataBaseUtil.Open(Settings.AUTConnectionString));
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
        //User can mention the custom log to text file.
        //Access to the log.txt after the execution completed in User.dir//Logs path
        Settings.log.Write("Browser Started");
        
        //Invoke Browser
        //@Param for GRID mention BrowserType.Grid or for single browser BrowserType.Firefox
        InitializeBrowser(BrowserType.FireFox);
        
        Settings.log.Write("Navigated to URL");
       //Navigate to the  URL        
        DriverContext.GoToUrl(Settings.URL);
        //Create excel object by passing the  Test Data sheet path
        ExcelUtil util = new ExcelUtil(Settings.ExcelSheetPath);

    }
    //This will run once after exeuction completion of each @Test
    @AfterMethod
    public void killBrowser(ITestResult result)
    {
    	if (result.getStatus()== ITestResult.SUCCESS)
    	{
    		LocalDriverContext.getRemoteWebDriverLocal().close();
         
         
    }
}
}


