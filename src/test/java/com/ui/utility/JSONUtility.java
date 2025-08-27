/**
 * @author: Avneet Kaur
 */

package com.ui.utility;

import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONUtility {
    public static String readJSON(String env) throws FileNotFoundException {
        Gson gson = new Gson();
        File jsonFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\ui\\config\\Config.json");
        FileReader fr = new FileReader(jsonFile);
        // below maps the entire json to config object
        Config config = gson.fromJson(fr, Config.class);
        Environment environment = config.getEnvironment().get(env);
        return environment.getURL();
        // http://www.automationpractice.pl/index.php
    }
}
