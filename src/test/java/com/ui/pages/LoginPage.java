package com.ui.pages;

import com.ui.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BrowserUtility {
    private WebDriverWait wait;
    public LoginPage(){
        super();
    }
    public void clickOn(By path){
        getWd().findElement(path).click();
    }
    public void fillInput(By path, String input){
        getWd().findElement(path).clear();
        getWd().findElement(path).sendKeys(input);
    }
    public void setExplicitWait(long explicitWait){
        wait = new WebDriverWait(getWd(),Duration.ofMillis(explicitWait));
    }
    public void scrollToElement(By path){

        JavascriptExecutor js = (JavascriptExecutor) getWd();
        System.out.println("error message came ");
        js.executeScript("arguments[0].scrollIntoView();", getWd().findElement(path));
    }

    public void waitForDisplayed(By error) {
        if(wait!=null)
        wait.until(ExpectedConditions.visibilityOfElementLocated(error));
        else{
            wait = new WebDriverWait(getWd(),Duration.ofMillis(10000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(error));
        }

    }
}
