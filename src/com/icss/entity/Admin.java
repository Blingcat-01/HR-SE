package com.icss.entity;

public class Admin {
    private int id;
    private String user_Name;
    private String user_Password;
    private int role;

    public Admin(int id, String user_Name, String user_Password, int role) {
        this.id = id;
        this.user_Name = user_Name;
        this.user_Password = user_Password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Password() {
        return user_Password;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
    }


}
