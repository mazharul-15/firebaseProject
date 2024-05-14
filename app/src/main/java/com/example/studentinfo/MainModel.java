package com.example.studentinfo;

public class MainModel {

    String name, email, url;
    int age;

    MainModel() {

    }

    public MainModel(String name, String email, String url, int age) {
        this.name = name;
        this.email = email;
        this.url = url;
        this.age = age;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
