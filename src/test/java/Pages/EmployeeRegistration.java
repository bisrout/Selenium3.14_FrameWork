package Pages;
/*
 * To create page functions ,the WebElement methods will be of format Webelement (NAME).(FUNCTION NAME)
 * Follow the below structure to design and customize own page object model
 */

import com.ea.Framework.Controls.elements.Button;
import com.ea.Framework.Controls.elements.TextBox;
import com.ea.Framework.base.BasePage;
import com.ea.Framework.base.DriverContext;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Random;

public class EmployeeRegistration extends BasePage {
	//WebElement Initialization
    @FindBy(how= How.ID,using="UserName")    
    public TextBox registerUserName;
    @FindBy(how= How.ID,using="Password")
    public TextBox registerPassword;
    @FindBy(how= How.ID,using="ConfirmPassword")
    public TextBox confirmPassword;
    @FindBy(how= How.ID,using="Email")
    public TextBox email;
    @FindBy(how= How.XPATH,using="//input[@type=\"submit\" and @value=\"Register\"]")
    public Button registerbtn;
  //Page functionalities
    public int  generateRandom(){
        // create instance of Random class
        Random rand = new Random();
        return rand.nextInt(1000);        
    }
    public void RegistrationProcess(String username,String pwd,String mailid) throws InterruptedException {
        DriverContext.WaitForElementVisible(registerUserName);
        registerUserName.EnterText(username);
        Thread.sleep(5000);
        registerPassword.EnterText(pwd);
        Thread.sleep(5000);
        confirmPassword.EnterText(pwd);
        Thread.sleep(5000);
        email.EnterText(mailid);
        Thread.sleep(5000);
        
    }
    public BasePage clickRegisterbtn ()
    {
        registerbtn.PerformClick();
        return Getinstanceof(HomePage.class);
    }

}
