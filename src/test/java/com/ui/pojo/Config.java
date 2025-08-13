package com.ui.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Config {
    // The @SerializedName annotation tells Gson to map the JSON key "environment"
    // to this field. The field name is also updated to match the getter/setter.
    @SerializedName("environment")
    Map<String,Environment> environment;

    public Map<String, Environment> getEnvironment() {
        return environment;
    }

    public void setEnvironment(Map<String, Environment> environmentMap) {
        this.environment = environmentMap;
    }
}
