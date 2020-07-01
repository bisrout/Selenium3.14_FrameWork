package Pages;

import com.ea.Framework.Controls.elements.Button;
import com.ea.Framework.Controls.elements.TextBox;
import com.ea.Framework.base.BasePage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {


    @FindBy(how = How.NAME, using = "UserName")
    public TextBox txtUsername;
    @FindBy(how = How.NAME, using = "Password")
    public TextBox txtPassword;
    @FindBy(how = How.XPATH, using = "//input[@value='Log in']")
    public Button txtLogin;


    public void Login(String username, String Password) throws InterruptedException {
        txtUsername.EnterText(username);
        txtPassword.EnterText(Password);
    }
    public BasePage clickLogin()
    {
        txtLogin.Click().Wait();
        //txtLogin.PerformClick();
        return Getinstanceof(HomePage.class);

    }




}
