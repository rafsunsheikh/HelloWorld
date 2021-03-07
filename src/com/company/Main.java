package com.company;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        //taking user input
        UserInput userInput = new UserInput();
        String userNameInput = userInput.getUserName();
        String passwordInput = userInput.getPassword();

        UserProfileDetails user1;

        //Converting to json format
        Gson json = new Gson();
        String response = null;

        //connection with database
        try {
            String url = "jdbc:mysql://localhost:3306/userprofile";
            String uName = "root";
            String pass = "1234";
            Class.forName("com.mysql.cj.jdbc.Driver"); //Class forName
            Connection con = DriverManager.getConnection(url, uName, pass);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from user natural join UserExperience natural join UserDetails where userName = '"+userNameInput+"' AND PASSWORD = '"+passwordInput+"'");

            while (rs.next()) {
                user1 = createProfile(rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getString(6),rs.getString(7),
                        rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11),
                        rs.getString(12), rs.getString(13),
                        rs.getString(14), rs.getString(15),
                        rs.getString(16));
                response = json.toJson(user1);
                System.out.println("Json created successfully\n" + response);
            }

            st.close();
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //Database connection and retrieve ends here


    }

    public static UserProfileDetails createProfile(String userName, String password, String fullName,
                                                   String phone, String email, String village, String postOffice,
                                                   String thana, String district, String zipCode,
                                                   String education, String workExperience,
                                                   String hobby, String favouriteColor, String favouriteFood){
        UserProfileDetails user = new UserProfileDetails();
        user.setUserName(userName);
        user.setPassword(password);
        user.setFullName(fullName);
        user.setPhone(phone);
        user.setEmail(email);
        user.address.setVillage(village);
        user.address.setPostOffice(postOffice);
        user.address.setThana(thana);
        user.address.setDistrict(district);
        user.address.setZipCode(zipCode);
        user.userExperience.setEducation(education);
        user.userExperience.setWorkExperience(workExperience);
        user.userDetails.setHobby(hobby);
        user.userDetails.setFavouriteColor(favouriteColor);
        user.userDetails.setFavouriteFood(favouriteFood);

        return user;
    }
}
