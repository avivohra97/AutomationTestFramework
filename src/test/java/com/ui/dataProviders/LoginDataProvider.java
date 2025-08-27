package com.ui.dataProviders;

import com.google.gson.*;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.ui.utility.CSVUtility;
import org.openqa.selenium.json.Json;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LoginDataProvider {
    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<User> loginDataProvider() throws IOException {
        // reading file with GSON
        Gson gson = new Gson();
        File file = new File(System.getProperty("user.dir")+"\\testData\\loginData.json");
        FileReader fr = new FileReader(file);
        TestData testData = gson.fromJson(fr, TestData.class);

        // get data of users from data object
        List<User> dataToReturn = new ArrayList<>();
        for(User user:testData.getData()){
            dataToReturn.add(user);
        }
        return dataToReturn.iterator();
    }

    @DataProvider(name = "LoginTestCSVDataProvider")
    public Iterator<User> loginCsvDataProvider(){
        return CSVUtility.readCSV();
    }
}
