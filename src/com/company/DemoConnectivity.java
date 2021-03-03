package com.company;
/*
* 1. import ---> java.sql
* Load and register the driver---> com.mysql.jdbc.Driver
* 3. create connection --> connection
* 4. create a statement --> Statement
* 5. execute a query
* 6. process a result
* 7. close
 */
//mysql tutorial
import java.sql.*;

public class DemoConnectivity {
    public void connection() throws Exception
    {
        try {
            String url = "jdbc:mysql://localhost:3306/userprofile";
            String uName = "root";
            String pass = "1234";
            Class.forName("com.mysql.cj.jdbc.Driver"); //Class forName
            Connection con = DriverManager.getConnection(url, uName, pass);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from user");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
                        + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
            }
            st.close();
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
