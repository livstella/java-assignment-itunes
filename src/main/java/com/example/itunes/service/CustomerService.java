package com.example.itunes.service;

import com.example.itunes.dao.CustomerDao;
import com.example.itunes.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("fakeDao") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public int addCustomer(Integer id,Customer customer) {
        return customerDao.insertCustomer(id, customer);
    }
}
