package com.example.itunes.dao;


import com.example.itunes.ConnectionManager;
import com.example.itunes.model.Customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface CustomerDao {

    //GET
    public List<Customer> getAllCustomers();
    public void getCustomerByID(Integer id);
    public void getCustomerByName(String name);
    public List<Customer> getLimitedCustomers(Integer limit, Integer offSet);
    public HashMap<String,Integer> getNumberOfCustomerByCountry();
    public HashMap<String, Integer> getHighestSpenders();
    public String getFavouriteGenre(String firstName);

    //PUT and POST
    public void addCustomer(String firstName,String lastName,String country,Integer postalCode,Integer phone,String email);
    public void updateCustomer(String firstName, String lastName, String country, Integer postalCode, Integer phone, String email, Integer id);

}
