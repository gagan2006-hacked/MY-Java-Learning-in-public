package com.Project.Dairy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// jdbc:mysql://localhost:3306/dailyrecord
public class DairyDao {
    private String url="jdbc:mysql://localhost:3306/mydairy";
    private String usr="root";
    private String pass="gagan@2006vishwa";
    private Connection connection;

    public DairyDao()throws RuntimeException{
        try {
            connection= DriverManager.getConnection(url,usr,pass);
        }catch (SQLException e){
            throw new RuntimeException("Error");
        }
    }

    public List<Dairy> getDataByDate(Date date){
        List<Dairy>list=new ArrayList<>();String query="select * from DailyRecord where date_of=?;";
        try{
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setDate(1,date);
            ResultSet set= statement.executeQuery();
            while (set.next()){
                int id=set.getInt("id");
                String title=set.getString("title");
                String data= set.getString("note");
                Date dat=set.getDate("date_of");
                Dairy dairy=new Dairy(id,title,data,dat);
                list.add(dairy);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Dairy getDairyById(int id){
        Dairy dairy=null;String query="select * from DailyRecord where id=?;";
        try{
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet set=statement.executeQuery();
            if (set.next()){
                String title=set.getString("title");
                String data= set.getString("note");
                Date dat=set.getDate("date_of");
                dairy=new Dairy(id,title,data,dat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dairy;
    }

    public boolean addANote(Dairy dairy){
        String qr= "insert into DailyRecord (title,note) value(?,?);";
        try{
            PreparedStatement statement= connection.prepareStatement(qr);
            statement.setString(1,dairy.getTittle());
            statement.setString(2,dairy.getData());
            int set=statement.executeUpdate();
            if (set>0)return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateDairy(Dairy dairy){
        String qr="update DailyRecord set note=?,title=? where id=?";
        try
        {
            PreparedStatement statement=connection.prepareStatement(qr);
            statement.setString(1,dairy.getData());
            statement.setString(2,dairy.getTittle());
            statement.setInt(3,dairy.getId());
            int set=statement.executeUpdate();
            if (set>0)return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateData(Dairy dairy){
        String qr="update DailyRecord set note=? where id=?";
        try
        {
            PreparedStatement statement=connection.prepareStatement(qr);
            statement.setString(1,dairy.getData());
            statement.setInt(2,dairy.getId());
            int set=statement.executeUpdate();
            if (set>0)return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean updateTitle(Dairy dairy){
        String qr="update DailyRecord set title=? where id=?";
        try
        {
            PreparedStatement statement=connection.prepareStatement(qr);
            statement.setString(1,dairy.getTittle());
            statement.setInt(2,dairy.getId());
            int set=statement.executeUpdate();
            if (set>0)return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDairy(int id){
        String qr="delete from DailyRecord where id =? ;";
        try
        {
            PreparedStatement statement=connection.prepareStatement(qr);
            statement.setInt(1,id);
            int set=statement.executeUpdate();
            if (set>0)return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Dairy> getAllDairy(){
        List<Dairy>list=new ArrayList<>();String query="select * from DailyRecord;";
        try{
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet set= statement.executeQuery();
            while (set.next()){
                int id=set.getInt("id");
                String title=set.getString("title");
                String data= set.getString("note");
                Date dat=set.getDate("date_of");
                Dairy dairy=new Dairy(id,title,data,dat);
                list.add(dairy);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Dairy> getDataByName(String input){
        List<Dairy>list=new ArrayList<>();
        String query = "SELECT * FROM DailyRecord WHERE title LIKE ?";
        try{
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, "%" + input + "%");
            ResultSet set= statement.executeQuery();
            while (set.next()){
                int id=set.getInt("id");
                String title=set.getString("title");
                String data= set.getString("note");
                Date dat=set.getDate("date_of");
                Dairy dairy=new Dairy(id,title,data,dat);
                list.add(dairy);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
