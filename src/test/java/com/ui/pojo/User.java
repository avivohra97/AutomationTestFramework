package com.ui.pojo;

public class User {
    private String email;
    private String password;
    private boolean expectedResult;

    public User(String email, String password, boolean expectedResult) {
        this.email = email;
        this.password = password;
        this.expectedResult = expectedResult;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGetExpectedResult() {
        return expectedResult;
    }

    public void setGetExpectedResult(boolean expectedResult) {
        this.expectedResult = expectedResult;
    }
}
