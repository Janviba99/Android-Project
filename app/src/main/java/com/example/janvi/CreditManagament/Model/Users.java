package com.example.janvi.CreditManagament.Model;

public class Users {
    String Name,Surname,Cr,Id;
    public Users(String id,String name,String surname,String cr)
    {
        Id=id;
        Name = name;
        Surname = surname;
        Cr = cr;
    }
    public Users(){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getCr() {
        return Cr;
    }

    public void setCr(String cr) {
        Cr = cr;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
