package com.model;

public class Account {
    private String name;
    private String mobile;
    private String email;
    private String password;

    // Getters and Setters
    public String getName() { return name; }

    public String getMobile() { return mobile; }

    public String getEmail() { return email; }

    public String getPassword() { return password; }

    // Constructor
    public Account(String name, String mobile, String email, String password) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
    }

    public Account() {
    }
}

