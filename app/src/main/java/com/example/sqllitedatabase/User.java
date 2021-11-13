package com.example.sqllitedatabase;

import com.orm.SugarRecord;

public class User extends SugarRecord {

    String name;
    String surname;
    String phonenumber;

    public User() {

    }

    public User(String name, String surname, String phonenumber) {
        this.name = name;
        this.surname = surname;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
