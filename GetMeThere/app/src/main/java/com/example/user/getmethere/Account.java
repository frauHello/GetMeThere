package com.example.user.getmethere;

public class User {

    private int id;
    private String name;
    private String email;
    private String account_password;
    private String re_pass;
    private String phone_num;
    private String adress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return account_password;
    }

    public void setPassword(String account_password) {
        this.password = account_password;
    }

    public String getRepass() {
        return re_pass;
    }

    public void setEmail(String re_pass) {
        this.email = re_pass;
    }

    public String getPhonum() {
        return phone_num;
    }

    public void setEmail(String phone_num) {
        this.email = phone_num;
    }

    public String getAdress() {
        return adress;
    }

    public void setEmail(String adress) {
        this.email = adress;
    }

}