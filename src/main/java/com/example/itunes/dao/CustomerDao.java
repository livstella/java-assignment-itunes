package com.example.itunes.dao;

import com.example.itunes.ConnectionManager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    public void getCustomerByID(Integer id);


}
