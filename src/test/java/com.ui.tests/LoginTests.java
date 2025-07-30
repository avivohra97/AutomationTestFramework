package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pages.MyAccountPage;
import com.ui.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

;


public class LoginTests {
    public static void main(String[] args) throws InterruptedException {
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
