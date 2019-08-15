package com.teamnaughty.food.myspringcrud.entity;

public class UserSession {
    public String email;

    public UserSession(){};
    public UserSession(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
