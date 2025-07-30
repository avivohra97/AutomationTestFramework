package com.ui.tests;

import com.ui.pages.LoginPage;
import com.ui.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.ui.utility.BrowserUtility.getWd;


public class LoginTests {
    public static void main(String[] args) throws InterruptedException {
//        WebDriver wd = new ChromeDriver();// launch a browser window or session
        LoginPage wd = new LoginPage();
        wd.gotoURL("http://www.automationpractice.pl/index.php");
        wd.manageWindow();

        wd.setImplicitWait(10000);
        By login = By.xpath("//a[@class='login']");
        wd.clickOn(login);

        By email = By.cssSelector("input[name='email']");
        By paswd = By.id("passwd");
        By loginBtn = By.id("SubmitLogin");
        wd.fillInput(email,"avn");
        wd.fillInput(paswd,"passed");
        wd.clickOn(loginBtn);
        wd.setExplicitWait(10000);



        By error = By.xpath("//p[text()='There is 1 error']");
        wd.waitForDisplayed(error);
        wd.scrollToElement(email);
        wd.fillInput(email,"bakomam596@skrak.com");
        wd.fillInput(paswd,"password");
        wd.clickOn(loginBtn);
    }
}
