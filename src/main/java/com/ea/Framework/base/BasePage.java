package com.ea.Framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends Base{
    //This method will be used to access the functions of each page
    public  <TPage extends BasePage>TPage As(Class<TPage> Pageinstance){
        try
        {
            return (TPage)this;

        }
        catch (Exception e){
            e.getStackTrace();

        }
        return null;
    }
}
