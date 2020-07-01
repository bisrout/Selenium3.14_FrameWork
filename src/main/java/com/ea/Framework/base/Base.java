package com.ea.Framework.base;

import com.ea.Framework.Controls.api.ControlFactory;
import org.openqa.selenium.support.PageFactory;

public class Base {

    public static BasePage currentpage;

    // This method will instantiate a new page.
    public  <TPage extends BasePage>TPage Getinstanceof(Class<TPage> Page){
    	Object obj = ControlFactory.initElements(LocalDriverContext.getRemoteWebDriverLocal(),Page);
        return Page.cast(obj);
    }

}
