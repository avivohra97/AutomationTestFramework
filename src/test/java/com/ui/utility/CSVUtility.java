package com.ui.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVUtility {
    public static Iterator<User> readCSV() {
        List<User> userList;
        File file = new File(System.getProperty("user.dir")+"\\testData\\loginData.csv");
        FileReader fr;
        CSVReader csvReader;
        String[] data;
        userList = new ArrayList<>();
        try{

            fr = new FileReader(file);
            csvReader = new CSVReader(fr);
            // This line reads and discards the header row before the main loop begins.
            csvReader.readNext();

            while((data = csvReader.readNext())!=null){
                User user = new User(data[0],data[1],Boolean.parseBoolean(data[2]));
                userList.add(user);
            }
        }catch (FileNotFoundException e ){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (CsvValidationException e){
            e.printStackTrace();
        }

        return userList.iterator();
    }
}
