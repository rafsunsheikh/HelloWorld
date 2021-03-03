package com.company;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args)  {

        //Taking input from terminal
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

            ResultSet rs = st.executeQuery("select * from user");

            while (rs.next()) {
                user1 = createProfile(rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getString(6),rs.getString(7),
                        rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11));
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

        //File Handling
        FileHandling file1 = new FileHandling();
        file1.createFile();
        file1.fileInformation();
        file1.writeToFile(response);
        file1.readFromFile();

    }

    public static UserProfileDetails createProfile(String userName, String password, String fullName,
                                                   String phone, String email, String village, String postOffice,
                                                   String thana, String district, String zipCode){
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

        return user;
    }
}
