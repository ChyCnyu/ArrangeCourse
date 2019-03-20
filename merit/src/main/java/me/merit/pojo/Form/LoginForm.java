package me.merit.pojo.Form;

import sun.rmi.runtime.Log;

public class LoginForm {
    private String id;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validate() {
        return ! (id == null || password == null || id.length() == 0 || password.length() == 0);
    }
}
