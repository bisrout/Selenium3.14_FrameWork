package SeleniumTest;
import Pages.EmployeeRegistration;
import Pages.HomePage;

import com.aventstack.extentreports.Status;
import com.ea.Framework.Utilities.ExcelUtil;
import com.ea.Framework.base.DriverContext;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.ea.Framework.Utilities.ExtentTestManager.*;

public class LoginTest extends TestInitialize {
	//Excel Object declaration
    public ExcelUtil util;
    
    //Create Your Test steps here 
    //User can enter Test attributes if required such as "dependsOnMehtods","priority","alwaysRun" etc.
    @Test()
    public void EmployeeRegistration() throws InterruptedException
    {
    	
    	//To get the Test case name 
    	String testCasename = Thread.currentThread().getStackTrace()[1].getMethodName();
    	
    	//Get instance of Page "HomePage" to access all the defined functionalities
    	currentpage=Getinstanceof(HomePage.class);
    	
    	//To navigate to another page instance by below syntax 
    	//Below syntax to navigate to page "EmployerRegistration" by using clickRegister()
    	currentpage=currentpage.As(HomePage.class).clickRegister();
    	
    	//Syntax to log info to the extent report
    	//@Param (Status,String)
    	getTest().log(Status.INFO,"Registration link clicked");
    	
    	//Driver will wait for all page element to be ready
        DriverContext.WaitForPageToLoad();
        
        //To generate random number
        int rand_User = currentpage.As(EmployeeRegistration.class).generateRandom();
        int rand_pwd = currentpage.As(EmployeeRegistration.class).generateRandom();
        int rand_ID = currentpage.As(EmployeeRegistration.class).generateRandom();
        
        //To get the test data for the test case  ExcelUtil.ReadCell to be used with
        //param @'ColumnName' ,@'testCasename'-Variable already defined above
        String userIntial = ExcelUtil.ReadCell("UserInit",testCasename);
        String pwdInitial = ExcelUtil.ReadCell("PwdInit",testCasename);
        String emailInitial = ExcelUtil.ReadCell("EmailInit",testCasename);
        
        //To continue with the same page function below syntax need to be followed
        currentpage.As(EmployeeRegistration.class).RegistrationProcess(userIntial+rand_User,pwdInitial+"_"+rand_pwd,emailInitial+rand_ID+"@gmail.com");
        getTest().log(Status.INFO,"Registration Details entered sucessfully");
        
        //Current page might not work when running in Parallel or Grid.
        //If this issue persists then Getinstanceof the page again and continue or create the page instance and call the desired function
        currentpage=Getinstanceof(EmployeeRegistration.class);
        currentpage=currentpage.As(EmployeeRegistration.class).clickRegisterbtn();
        
        //Log for each step
        getTest().log(Status.INFO,"User click register"); 
        
        //TestNG assertion for any data validation
        Assert.assertEquals("Home Page is not arrived",currentpage.As(HomePage.class).isLoggofftxt(),"Lo off!");
       
    }
    
    
    
    
    
    
    }

