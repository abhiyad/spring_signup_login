package com.springframework.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "fname")
    public String fname;
    @Column(name = "lname")
    public String lname;
    public String getFname(){
        return this.fname;
    }
    public void setFname(String fname){
        this.fname = fname;
    }
    public String getLname(){ return this.lname; }
    public void setLname(String lname){
        this.lname=lname;
    }
    public Person(String a , String b){
        this.fname = a ;
        this.lname = b;
    }
    public Person(){}
    public Long getid(){return this.id; }
}
