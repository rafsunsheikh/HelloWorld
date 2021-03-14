package com.company;

import java.util.Scanner;

public class Address {
    private String village;
    private String postOffice;
    private String thana;
    private String zilla;
    private String country;

    //all the get methods
    public void setVillage(String village){
        this.village = village;
    }
    public void setPostOffice(String postOffice){
        this.postOffice= postOffice;
    }
    public void setThana(String thana){
        this.thana = thana;
    }
    public void setZilla(String zilla){
        this.zilla = zilla;
    }
    public void setCountry(String country){
        this.country = country;
    }

    //all the get methods
    public String getVillage(){
        return village;
    }
    public String getPostOffice(){
        return postOffice;
    }
    public String getThana(){
        return thana;
    }
    public String getZilla(){
        return zilla;
    }
    public String getCountry(){
        return country;
    }

}

