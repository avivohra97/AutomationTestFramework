package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginTests {
    public static void main(String[] args) throws InterruptedException {
        WebDriver wd = new ChromeDriver();// launch a browser window or session
        wd.get("http://www.automationpractice.pl/index.php");
        wd.manage().window().maximize();

        wd.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        WebElement login = wd.findElement(By.xpath("//a[@class='login']"));
        login.click();
        WebElement email = wd.findElement(By.cssSelector("input[name='email']"));
        WebElement paswd = wd.findElement(By.id("passwd"));
        WebElement loginBtn = wd.findElement(By.id("SubmitLogin"));
        email.sendKeys("avn");
        paswd.sendKeys("passed");
        loginBtn.click();
        WebDriverWait wait = new WebDriverWait(wd,Duration.ofSeconds(10));


        WebElement error = wd.findElement(By.xpath("//p[text()='There is 1 error']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='There is 1 error']")));
        JavascriptExecutor js = (JavascriptExecutor) wd;
        System.out.println("error message came "+error.isDisplayed());

        email = wd.findElement(By.cssSelector("input[name='email']"));
        paswd = wd.findElement(By.id("passwd"));
        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", email);
        email.clear();
        paswd.clear();
        loginBtn = wd.findElement(By.id("SubmitLogin"));
        email.sendKeys("bakomam596@skrak.com");
        paswd.sendKeys("password");
        loginBtn.click();
    }
}
