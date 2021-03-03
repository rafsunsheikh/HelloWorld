/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

//import allprojects.practice.dbcon.DBConnection;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Dell
 */
public class ObjectToJson {

    public static void main(String[] args) {
        Gson gson = new Gson();
        UserProfile user1, user2;     
        
        user2 = createProfile("sm", "654321", "2345678");
        System.out.println(gson.toJson(user2));
        
        // from DB
        // String username = "selim";        
        try {
            Connection con = DBConnection.getInstance().getDBConnection();
            Statement stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery("select * from user where username = '"+username+"'");
            ResultSet rs = stmt.executeQuery("select * from user");            
            while (rs.next()) {
                user1 = createProfile(rs.getString(2), rs.getString(3), rs.getString(4));
                System.out.println(gson.toJson(user1));
            }
           
            con.close();
        } catch (Exception e) {

        }

        
    }

    public static UserProfile createProfile(String userName, String password, String studentId) {
        UserProfile user = new UserProfile();
        user.setUserName(userName);
        user.setPassword(password);
        return user;
    }
}
