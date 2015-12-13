package com.example.sebat.resume;

/**
 * Created by Sebat on 11/27/2015.
 */
public class Connect {

    public Connect(String name,String username,String pass){
        this.setName(name);
        this.setUsername(username);
        this.setPass(pass);

    }

    private String name;
    private String username;
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }



}
