package com.assessment1.controller;

public class AppointmentForm {
    private String name;
    private String mobile;
    private String age;

    public AppointmentForm() {
        super();
    }

    public AppointmentForm(String name, String mobile, String age) {
        this.name = name;
        this.mobile = mobile;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
