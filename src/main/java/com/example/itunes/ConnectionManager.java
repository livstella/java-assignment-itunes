package com.example.itunes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    static final String URL = "jdbc:sqlite:C:\\Users\\JJoha2\\Documents\\repos\\Java\\Assignments\\Assignment2\\java-assignment-itunes\\src\\main\\resources\\Chinook_Sqlite.sqlite";
    static private ConnectionManager instance;
    private Connection connection;

    static ConnectionManager getInstance(){
      if (instance == null){
          instance = new ConnectionManager();
      }
      return instance;
    }

    private ConnectionManager(){
        try {
            connection = DriverManager.getConnection(URL);
        }catch (SQLException sqe){
            sqe.printStackTrace();
            System.exit(-1);
        }

    }

    public Connection getConnection(){
        return connection;
    }


}
