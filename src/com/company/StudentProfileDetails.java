package com.company;

import java.util.Scanner;

public class StudentProfileDetails {

    private int studentId;
    private String name;


    Address address = new Address();

    //All the set methods
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    public void setName(String name){
        this.name = name;
    }


    //all the get methods
    public int getStudentId(){
        return studentId;
    }
    public String getName(){
        return name;
    }


}


