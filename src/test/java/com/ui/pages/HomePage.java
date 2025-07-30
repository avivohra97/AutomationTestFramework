package com.ui.pages;

import com.google.j2objc.annotations.Weak;
import com.ui.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BrowserUtility {

    public HomePage(String driver){
        super(driver);
    }
    private final String URL = "http://www.automationpractice.pl/index.php";
    By login = By.xpath("//a[@class='login']");

    public LoginPage gotoLoginPage(){
        gotoURL(URL);
        clickOn(login);
        LoginPage loginPage = new LoginPage(getWd());
        return loginPage;
    }
}
