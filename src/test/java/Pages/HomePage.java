package Pages;
/*
 * To create page functions ,the WebElement methods will be of format Webelement (NAME).(FUNCTION NAME)
 * Follow the below structure to design and customize own page object model
 */

import com.ea.Framework.Controls.elements.Hyperlink;
import com.ea.Framework.base.BasePage;
import com.ea.Framework.base.DriverContext;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class  HomePage extends BasePage {
	//WebElement Initialization
    @FindBy(how= How.LINK_TEXT,using="Login")
    public Hyperlink lnklogin;
    @FindBy(how= How.LINK_TEXT,using="Employee List")
    public Hyperlink linkEmployeeList;
    @FindBy(how= How.XPATH,using="//a [@href=\"/Manage\"]")
    public Hyperlink linkUsername;
    @FindBy(how= How.LINK_TEXT,using="Log off")
    public Hyperlink linkLogoff;
    @FindBy(how= How.XPATH,using="//a[@href=\"/Account/Register\"]")
    public Hyperlink lnkRegister;
    //Page functionalities
    public  LoginPage ClickLogin(){
    	//Below steps to be followed to get the Webelemnt method
        lnklogin.ClickLink();
        lnklogin.Wait();      
        return Getinstanceof(LoginPage.class);
    }

    public void ClickLogoff() throws InterruptedException {
    	linkLogoff.ClickLink();
        Thread.sleep(3000);
    }
    public EmployeeRegistration clickRegister()   {
        lnkRegister.ClickLink();
        return Getinstanceof(EmployeeRegistration.class);
    }
    public boolean isLogin(){
        return lnklogin.isEnabled();
    }
    public String isLinkUsername(){
    	 return linkUsername.WaitForVisible().getText();        
    }
    public String isLoggofftxt(){
    	return linkLogoff.WaitForVisible().getText();       
    }
}
