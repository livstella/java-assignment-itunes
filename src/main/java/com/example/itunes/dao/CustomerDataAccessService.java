package com.example.itunes.dao;

import com.example.itunes.ConnectionManager;
import com.example.itunes.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerDataAccessService {
    PreparedStatement preparedStatement = null;
    Connection conn = ConnectionManager.getInstance().getConnection();

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM Customer");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("CustomerId");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String country = resultSet.getString("Country");
                Integer postalCode = resultSet.getInt("PostalCode");
                Integer phone = resultSet.getInt("Phone");
                String email = resultSet.getString("Email");

                System.out.println(id + firstName + lastName + country + postalCode + phone + email);
                Customer x = new Customer(id, firstName, lastName, country, postalCode, phone, email);
                customerList.add(x);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;

    }

    ;

    public void getCustomerByID(Integer id) {


        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM Customer WHERE CustomerId=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Integer Id = resultSet.getInt("CustomerId");
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            String country = resultSet.getString("Country");
            Integer postalCode = resultSet.getInt("PostalCode");
            Integer phone = resultSet.getInt("Phone");
            String email = resultSet.getString("Email");

            System.out.println(id + firstName + lastName + country + postalCode + phone + email);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void getCustomerByName(String name) {


        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM Customer WHERE FirstName LIKE ?");
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            Integer id = resultSet.getInt("CustomerId");
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            String country = resultSet.getString("Country");
            Integer postalCode = resultSet.getInt("PostalCode");
            Integer phone = resultSet.getInt("Phone");
            String email = resultSet.getString("Email");

            System.out.println(id + firstName + lastName + country + postalCode + phone + email);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public List<Customer> getLimitedCustomers(Integer limit, Integer offSet) {
        List<Customer> customerList = new ArrayList<>();

        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM Customer LIMIT ? OFFSET ?");
            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offSet);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("CustomerId");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String country = resultSet.getString("Country");
                Integer postalCode = resultSet.getInt("PostalCode");
                Integer phone = resultSet.getInt("Phone");
                String email = resultSet.getString("Email");

                System.out.println(id + firstName + lastName + country + postalCode + phone + email);
                Customer x = new Customer(id, firstName, lastName, country, postalCode, phone, email);
                customerList.add(x);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;

    }

    ;

    public void addCustomer(String firstName, String lastName, String country, Integer postalCode, Integer phone, String email) {


        try {
            preparedStatement = conn.prepareStatement("INSERT INTO Customer (FirstName, LastName, Country, PostalCode, Phone, email) VALUES('firstName', 'lastName', 'country', 'postalCode', 'phone', 'email')");


            preparedStatement.executeUpdate();


            System.out.println("Success!..?");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void updateCustomer(String firstName, String lastName, String country, Integer postalCode, Integer phone, String email, Integer id) {


        try {
            preparedStatement = conn.prepareStatement("UPDATE Customer SET FirstName=?, LastName=?, Country=?, PostalCode=?, Phone=?, Email=? WHERE CustomerId=?");

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, country);
            preparedStatement.setInt(4, postalCode);
            preparedStatement.setInt(5, phone);
            preparedStatement.setString(6, email);
            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();


            System.out.println("Success!..?");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public HashMap<String, Integer> getNumberOfCustomerByCountry() {
        HashMap<String, Integer> customersInCountries = new HashMap<>();

        try {
            preparedStatement = conn.prepareStatement("SELECT COUNT(CustomerId), Country FROM Customer GROUP BY Country ORDER BY COUNT(CustomerId) DESC");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String country = resultSet.getString("Country");
                Integer number = resultSet.getInt("COUNT(CustomerId)");
                customersInCountries.put(country, number);

                System.out.println(country + ": " + number);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customersInCountries;
    }

    public HashMap<String, Integer> getHighestSpenders() {
        HashMap<String, Integer> highestSpenders = new HashMap<>();

        try {
            preparedStatement = conn.prepareStatement("SELECT  FirstName, SUM(Total) FROM Invoice INNER JOIN Customer C on C.CustomerId = Invoice.CustomerId GROUP BY Invoice.CustomerId ORDER BY SUM(Total) DESC");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("FirstName");
                Integer total = resultSet.getInt("SUM(Total)");
                highestSpenders.put(name, total);

                System.out.println(name + ": " + total);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return highestSpenders;
    }


    public String getFavouriteGenre(String firstName) {
        String favouriteGenre="";
        try {
            preparedStatement = conn.prepareStatement("SELECT MAX(g.Name) FROM InvoiceLine\n" +
                    "INNER JOIN Track T on InvoiceLine.TrackId = T.TrackId\n" +
                    "INNER JOIN Genre G on G.GenreId = T.GenreId\n" +
                    "INNER JOIN Invoice I on I.InvoiceId = InvoiceLine.InvoiceId\n" +
                    "INNER JOIN Customer C on C.CustomerId = I.CustomerId\n" +
                    "WHERE C.FirstName LIKE ?" +
                    "GROUP BY G.Name\n" +
                    "ORDER BY COUNT(G.GenreId) DESC;");

            preparedStatement.setString(1, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();


            favouriteGenre=resultSet.getString("MAX(g.Name)");
            System.out.println(favouriteGenre);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    return favouriteGenre;
    }

}
