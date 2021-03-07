package com.company;

public class UserDetails {
    private String hobby;
    private String favouriteColor;
    private String favouriteFood;

    //Set methods
    public void setHobby(String hobby){
        this.hobby = hobby;
    }
    public void setFavouriteColor(String favouriteColor){
        this.favouriteColor = favouriteColor;
    }
    public void setFavouriteFood(String favouriteFood){
        this.favouriteFood = favouriteFood;
    }

    //Get Methods
    public String getHobby(){
        return hobby;
    }
    public String getFavouriteColor(){
        return favouriteColor;
    }
    public String getFavouriteFood(){
        return favouriteFood;
    }


}
