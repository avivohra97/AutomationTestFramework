package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pages.MyAccountPage;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTestsTestNg {

    HomePage wd;

    @BeforeMethod(description = "Before method starts")
    public void setup() throws IOException {
        wd = new HomePage("chrome");
        wd.manageWindow();
        wd.setImplicitWait(10000);

    }

    @Test(description = "Login flow", groups = {"e2e","sanity"})
    public void loginTest() {
        LoginPage loginPage = wd.gotoLoginPage();
        loginPage.fillCreds("avn","passed");
        wd.setExplicitWait(10000);
        MyAccountPage myAccountPage = loginPage.fillCreds("bakomam596@skrak.com","password");
        assertEquals(myAccountPage.nameDisplayed(),"Jatin Sharma");
    }
}
