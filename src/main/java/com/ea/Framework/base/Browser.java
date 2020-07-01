package com.ea.Framework.base;

import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {

    private RemoteWebDriver _Driver;

    public Browser(RemoteWebDriver _Driver) {
        this._Driver = _Driver;
    }  
    public void GoToUrl(String url)
    {
        _Driver.get(url);
    }
    public void Maximize()
    {
        _Driver.manage().window().maximize();
    }

}
