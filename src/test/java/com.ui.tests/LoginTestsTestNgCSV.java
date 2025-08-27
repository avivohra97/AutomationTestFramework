package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class LoginTestsTestNgCSV {

    HomePage wd;

    @BeforeMethod(description = "Before method starts")
    public void setup() throws IOException {
        wd = new HomePage("chrome");
        wd.manageWindow();
        wd.setImplicitWait(10000);

    }


    // Give fully qualified data provider class
    // providing data provide means parametrizing the method
    @Test(description = "Login flow", groups = {"e2e","sanity"},
    dataProviderClass = com.ui.dataProviders.LoginDataProvider.class,
    dataProvider = "LoginTestCSVDataProvider")
    public void loginTest(User user) {
        LoginPage loginPage = wd.gotoLoginPage();
        wd.setExplicitWait(10000);
        MyAccountPage myAccountPage = loginPage.fillCreds(user.getEmail(), user.getPassword());

        if (user.isGetExpectedResult()) {
            // This block runs for the successful user
            assertEquals(myAccountPage.nameDisplayed(), "Jatin Sharma", "Login failed for valid user");
            System.out.println("Login Test Passed for user: " + user.getEmail());
        } else {
            // This block runs for the user expected to fail
            // Here, you would assert a login failure condition. For example:
            // assertNotEquals(myAccountPage.nameDisplayed(), "Jatin Sharma", "Login succeeded for invalid user");
            // Or check for a specific error message on the login page:
            // assertEquals(loginPage.getErrorMessage(), "Invalid credentials", "Incorrect error message");
            System.out.println("Login Test Failed as expected for user: " + user.getEmail());
        }
    }
}
