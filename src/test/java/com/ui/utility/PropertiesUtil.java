package com.ui.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    public String loadProperties(String key) throws IOException {
        File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\ui\\config\\QA.properties");
        FileReader fileReader = new FileReader(propFile);

        Properties prop = new Properties();
        prop.load(fileReader);
        return prop.getProperty(key);
    }
}
