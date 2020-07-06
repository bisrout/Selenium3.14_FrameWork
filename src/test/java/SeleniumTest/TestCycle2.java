package SeleniumTest;

import static com.ea.Framework.Utilities.ExtentTestManager.*;

import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ea.Framework.Config.Settings;
import com.ea.Framework.Utilities.ExcelUtil;
import com.ea.Framework.base.BasePage;
import com.ea.Framework.base.DriverContext;

import Pages.HomePage;
import Pages.LoginPage;

public class TestCycle2 extends TestInitialize {
	
	
	 @Test()

	    public void Validation_POST_call() throws InterruptedException{
		 String testCasename = Thread.currentThread().getStackTrace()[1].getMethodName();
	        Settings.log.Write("Home Page logged in");
	        currentpage=Getinstanceof(HomePage.class);
	        currentpage =  currentpage.As(HomePage.class).ClickLogin();
	        getTest().log(Status.INFO,"User clicked login link");      
	        currentpage.As(LoginPage.class).Login(ExcelUtil.ReadCell("UserName",testCasename), ExcelUtil.ReadCell("PassWord",testCasename));                
	        getTest().log(Status.INFO,"User sucessfully entered the username and Password");
	        currentpage= currentpage.As(LoginPage.class).clickLogin();
	        getTest().log(Status.INFO,"Sucessfully Logged In");
	        DriverContext.WaitForPageToLoad();
	      
	        Assert.assertEquals("Home Page is not arrived", currentpage.As(HomePage.class).isLinkUsername()," biswajit");
	       
	 }
}
	 
