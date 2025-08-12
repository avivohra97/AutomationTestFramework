package com.ui.pages;

import com.ui.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BrowserUtility {
    private final static By name = By.xpath("//a[@class='account']/span");
    public MyAccountPage(WebDriver driver){
        super(driver);
    }


    public String nameDisplayed() {
        waitForDisplayed(name);
        String text = getWd().findElement(name).getText();
        System.out.println("name found on page is "+text);
        return text;
    }
}
