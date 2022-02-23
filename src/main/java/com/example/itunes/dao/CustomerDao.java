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
    public List<Customer> getAllCustomers();
    public void getCustomerByID(Integer id);
    public void getCustomerByName(String name);
    public List<Customer> getLimitedCustomers(Integer limit, Integer offSet);
    public HashMap<String,Integer> getNumberOfCustomerByCountry();

    public void addCustomer(String firstName,String lastName,String country,Integer postalCode,Integer phone,String email);


}
