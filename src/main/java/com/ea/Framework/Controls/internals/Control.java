package com.ea.Framework.Controls.internals;
/*
 * This is WebElement method interface
 * Mention only the abstract body.
 */
import com.ea.Framework.Controls.api.ImplementedBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;
@ImplementedBy(ControlBase.class)
public interface Control extends WebElement, WrapsElement, Locatable {

	ControlBase Wait();

	ControlBase WaitForVisible();

	ControlBase Click();

	ControlBase ScrollToElement();
	
	ControlBase doubleClcik();
	
		

}
