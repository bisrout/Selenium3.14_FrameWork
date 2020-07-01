package com.ea.Framework.Utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ea.Framework.base.LocalDriverContext;
import com.google.common.io.Files;
import static com.ea.Framework.Utilities.ExtentManager.*;
/*
 * Listener class Implemented by @TestNG class
 */

public class TestListners implements ITestListener {
	//This will start when suite execution Begins
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}
    //Display when Suite execution completes
	public synchronized void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
    //Invoked when @Test execution starts
	public synchronized void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
		ExtentTestManager.getTest().log(Status.INFO,"*** Test execution " + result.getMethod().getMethodName() + "Started");
	}
    //Invoked when @Test passes
	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}
    //Invoked when @Test Fails
	public synchronized void onTestFailure(ITestResult result) {
		ExtentTestManager.getTest().log(Status.INFO,"*** Test execution " + result.getMethod().getMethodName() + " failed...");
		ExtentTestManager.getTest().log(Status.INFO,result.getMethod().getMethodName() + " failed!");		
		String targetLocation = null;
		String testMethodName = result.getName().toString().trim();
		String fileSeperator = System.getProperty("file.separator");
		String reportsPath =reportFilepath+fileSeperator+"TestReport_"+currentTime;
		ExtentTestManager.getTest().log(Status.INFO,"Screen shots reports path - " + reportsPath);
		try {
			File file = new File(reportsPath + fileSeperator +"screenshot"); // Set
																				// screenshots
																				// folder
			if (!file.exists()) {
				if (file.mkdirs()) {
					ExtentTestManager.getTest().log(Status.INFO,"Directory: " + file.getAbsolutePath() + " is created.");
				} else {
					ExtentTestManager.getTest().log(Status.INFO,"Failed to create directory: " + file.getAbsolutePath());
				}

			}

			File screenshotFile = ((TakesScreenshot)LocalDriverContext.getRemoteWebDriverLocal()).getScreenshotAs(OutputType.FILE);
			targetLocation = reportsPath + fileSeperator +"screenshot" +fileSeperator+ testMethodName+"_"+currentTime+".png" ;// define
																											// location
			File targetFile = new File(targetLocation);
			ExtentTestManager.getTest().log(Status.INFO,"Screen shot file location - " + screenshotFile.getAbsolutePath());
			ExtentTestManager.getTest().log(Status.INFO,"Target File location - " + targetFile.getAbsolutePath());
			Files.copy(screenshotFile, targetFile);

		} catch (FileNotFoundException e) {
			ExtentTestManager.getTest().log(Status.INFO,"File not found exception occurred while taking screenshot " + e.getMessage());
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.INFO,"An exception occurred while taking screenshot " + e.getCause());
		}

		// attach screenshots to report
		try {
			ExtentTestManager.getTest().fail("Screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
		} catch (IOException e) {
			ExtentTestManager.getTest().log(Status.INFO,"An exception occured while taking screenshot " + e.getCause());
		}
		if (result.getStatus()==ITestResult.FAILURE) {
			ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
		}
		
   	
		
		LocalDriverContext.getRemoteWebDriverLocal().close();
	}

	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}
	

}
