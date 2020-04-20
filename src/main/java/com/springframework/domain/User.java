package com.springframework.domain;

public class User {
    private String fname;
    private String lname;
    public String getFname(){
        return fname;
    }
    public String setFname(String fname){
        return this.fname = fname;
    }
    public String getLname(){
        return lname;
    }
    public String setLname(String lname){
        return this.lname=lname;
    }
}
