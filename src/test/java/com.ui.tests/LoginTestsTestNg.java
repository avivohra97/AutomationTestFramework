package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pages.MyAccountPage;
import org.testng.annotations.Test;


public class LoginTestsTestNg {
    @Test
    public void loginTest() {
        HomePage wd = new HomePage("chrome");
        wd.manageWindow();
        wd.setImplicitWait(10000);
        LoginPage loginPage = wd.gotoLoginPage();
        loginPage.fillCreds("avn","passed");
        wd.setExplicitWait(10000);
        loginPage.errorMessageDisplayed();

        MyAccountPage myAccountPage = loginPage.fillCreds("bakomam596@skrak.com","password");
        myAccountPage.nameDisplayed();
    }
}
