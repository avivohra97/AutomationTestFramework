package com.ui.pages;

import com.google.j2objc.annotations.Weak;
import com.ui.utility.BrowserUtility;
import com.ui.utility.JSONUtility;
import com.ui.utility.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HomePage extends BrowserUtility {

    public HomePage(String driver) throws IOException {
        super(driver);
    }
    private final String URL = new PropertiesUtil().loadProperties("URL");

    By login = By.xpath("//a[@class='login']");

    public LoginPage gotoLoginPage(){
        try {
            gotoURL(JSONUtility.readJSON("QA"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        clickOn(login);
        LoginPage loginPage = new LoginPage(getWd());
        return loginPage;
    }
}
