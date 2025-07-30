package com.ui.pages;

import com.ui.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BrowserUtility {

    private By email = By.cssSelector("input[name='email']");
    private By paswd = By.id("passwd");
    private By loginBtn = By.id("SubmitLogin");
    By error = By.xpath("//p[text()='There is 1 error']");
    public LoginPage(WebDriver wd){
        super(wd);
    }
    public MyAccountPage fillCreds(String emailValue, String passwordValue){
        scrollToElement(email);
        fillInput(email,emailValue);
        fillInput(paswd,passwordValue);
        clickOn(loginBtn);
        return new MyAccountPage(getWd());
    }
    public void errorMessageDisplayed(){
        waitForDisplayed(error);
    }


}
