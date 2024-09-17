package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Con {
    private Connection connection;
    public Statement statement;

    public Con(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelMS", "root", "Mysql1");
            statement = connection.createStatement();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Con();
   }
}