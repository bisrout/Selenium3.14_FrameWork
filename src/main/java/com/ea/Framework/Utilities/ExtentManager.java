package com.ea.Framework.Utilities;
/*
 * Utility to create HTML report
 */

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static final String currentTime = LogUtil.TimeStamp();
	 private static ExtentReports extent;
	    private static String reportFileName = "Test-Automaton-Report";
	    private static String fileSeperator = System.getProperty("file.separator");
	    public static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "AutomationReport";
	    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
	  
	 
	    public static ExtentReports getInstance() {
	        if (extent == null)
	            createInstance();
	        return extent;
	    }
	 
	    //Create an extent report instance
	    public static ExtentReports createInstance() {
	    	
	    	
		    //Create folder for all the test cases ran on specific time.
	        String fileName = getReportPath(reportFilepath+fileSeperator+"TestReport_"+currentTime);
	       //Configure HTML report detail and looks.
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(reportFileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(reportFileName);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	 
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        //Set environment details
			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("AUT", "QA");
			extent.setSystemInfo("Application", "SalesForce");
			
	 
	        return extent;
	    }
	     
	    //Create the report path
	    public static String getReportPath (String path) {
	    	File testDirectory = new File(path);
	        if (!testDirectory.exists()) {
	        	if (testDirectory.mkdir()) {
	                System.out.println("Directory: " + path + " is created!" );
	                return path+fileSeperator+reportFileName+"_"+currentTime+".html";
	            } else {
	                System.out.println("Failed to create directory: " + path);
	                return System.getProperty("user.dir");
	            }
	        } else {
	            System.out.println("Directory already exists: " + path);
	        }
			return path+fileSeperator+reportFileName+"_"+currentTime+".html";
	    }
	   
}
