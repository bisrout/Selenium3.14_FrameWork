package com.ea.Framework.Controls.internals;
/*
 *Refer the below implemented method  to perform multiple webelement action
 *To creat your own method -: follow below steps
 *-Creat an abstract method @ Control.Java interface
 *-Implement the same in below class 
 */

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Coordinates;

import com.ea.Framework.base.DriverContext;

import java.util.List;

public class ControlBase implements Control {

    private final WebElement element;

    public ControlBase(WebElement element) {
        this.element = element;
    }

    @Override
    public void click() {
        element.click();

    }

    @Override
    public void submit() {
        element.submit();

    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        element.sendKeys(charSequences);

    }

    @Override
    public void clear() {
        element.clear();

    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public String getText() {
        return element.getText();

    }

    @Override
    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return element.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return element.getScreenshotAs(target);
    }

    @Override
    public WebElement getWrappedElement() {
        return element;
    }

    @Override
    public Coordinates getCoordinates() {
        return getCoordinates();
    }
    @Override
    public ControlBase Wait()
    {
    	DriverContext.WaitForPageToLoad();
    	return this;
    }
    @Override
    public ControlBase WaitForVisible()
    {
    	DriverContext.WaitForElementVisible(getWrappedElement());
    	return this;
    }
    @Override
    public ControlBase Click()
    {
    	getWrappedElement().click();
    	return this;
    }
    @Override
    public ControlBase ScrollToElement()
    {
    	//Java Script To be designed.
    	return this;
    }
    public ControlBase doubleClcik()
    {
    	//Java Script To be designed.
    	return this;
    }
    
    
}
