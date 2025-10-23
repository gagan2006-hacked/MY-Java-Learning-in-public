package com.JDBC.Practice;

import java.sql.*;

public class Practice {
    private static final String url="jdbc:mysql://localhost:3306/org";
    private static final String user="root";
    private static final String pass="gagan@2006vishwa";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection connection= DriverManager.getConnection(url,user,pass);
            Statement s=connection.createStatement();
            String string= "SELECT * FROM workers;";
            ResultSet data=s.executeQuery(string);
            while (data.next()){
                System.out.println("Wid:"+data.getInt("wid"));
                System.out.println("name :"+data.getString("wfirstname")+" "+data.getString("wlastname"));
                System.out.println("Bounty :"+data.getString("salary"));
            }
        }catch (
                SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
