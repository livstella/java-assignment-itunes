package com.example.itunes.dao;

import com.example.itunes.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDataAccessService {
    Connection conn = ConnectionManager.getInstance().getConnection();

        PreparedStatement preparedStatement;

    {
        try {
            preparedStatement = conn.prepareStatement("SELECT Name  from Genre WHERE Name LIKE ?");
            preparedStatement.setString(1, "Rock");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String genreName = resultSet.getString("Name");

                System.out.println(genreName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



        try {

        PreparedStatement testStatement = conn.prepareStatement("SELECT * FROM Customer LIMIT 20");
        ResultSet testSet = testStatement.executeQuery();

        while (testSet.next()) {
            String customerName = testSet.getString("FirstName");
            System.out.println(customerName);
        }
        conn.close();

    } catch (SQLException sqe) {
        sqe.printStackTrace();
        System.exit(-1);
    }
}
