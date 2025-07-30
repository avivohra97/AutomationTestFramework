package com.ui.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BrowserUtility {
    private WebDriver wd;
    private WebDriverWait wait;
    public BrowserUtility(WebDriver driver){
        wd = driver;
    }
    public BrowserUtility(String driver){
        switch (driver){
            case "chrome":
                wd = new ChromeDriver();
                break;
            case "edge":
                wd = new EdgeDriver();
                break;
            default:
                System.err.println("Select either chrome or edge as browser");
        }
    }

    public  WebDriver getWd() {
        return wd;
    }

    public void setWd(WebDriver wd) {
        this.wd = wd;
    }

    public void gotoURL(String URL){
        wd.get(URL);
    }
    public void manageWindow(){
        wd.manage().window().maximize();
    }
    public void setImplicitWait(long milliSec){
        wd.manage().timeouts().implicitlyWait(Duration.ofMillis(milliSec));
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
