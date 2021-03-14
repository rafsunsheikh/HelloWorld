package com.company;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args)  {
        //taking user input
        StudentInput studentInput = new StudentInput();
        int studentIdInput = studentInput.getStudentId();


        StudentProfileDetails user1;
        CreateProfile profile = new CreateProfile();

        //Converting to json format
        Gson json = new Gson();
        String response = null;

        //connection with database
        try {
            String url = "jdbc:mysql://localhost:3306/mist";
            String uName = "root";
            String pass = "1234";
            Class.forName("com.mysql.cj.jdbc.Driver"); //Class forName
            Connection con = DriverManager.getConnection(url, uName, pass);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from student where studentId = '"+studentIdInput+"' ");

            if(!rs.next()) {
                System.out.println("Student Id not matched");
            }
            else{

                user1 = profile.createProfile(rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getString(6),rs.getString(7),
                        rs.getString(8));
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

}
