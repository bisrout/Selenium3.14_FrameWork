package com.ea.Framework.Controls.elements;

import com.ea.Framework.Controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class HyperlinkBase  extends ControlBase implements Hyperlink {
    public HyperlinkBase(WebElement element) {
        super(element);
    }

    @Override
    public void ClickLink() {
        getWrappedElement().click();

    }

    @Override
    public String GetUrlText() {
        return getWrappedElement().getText();
    }

    @Override
    public boolean CheckUrlTextContains(String containsText) {
        if (getWrappedElement().getText().contains(containsText))
            return true;
        else
            return false;
    }
}
