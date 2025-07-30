package com.ui.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class BrowserUtility {
    private static WebDriver wd;
    public BrowserUtility(){
        wd = new ChromeDriver();
    }

    public static WebDriver getWd() {
        return wd;
    }

    public static void setWd(WebDriver wd) {
        BrowserUtility.wd = wd;
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


}
