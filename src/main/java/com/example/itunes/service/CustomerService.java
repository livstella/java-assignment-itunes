package com.example.itunes.service;

import com.example.itunes.dao.CustomerDataAccessService;
import com.example.itunes.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerDataAccessService customerDao;

    @Autowired
    public CustomerService(@Qualifier("CustomerDao") CustomerDataAccessService customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public void getCustomerByID(Integer id) {
        customerDao.getCustomerByID(id);
    }

    public void getCustomerByName(String name) {
        customerDao.getCustomerByName(name);
    }

    public List<Customer> getLimitedCustomer(Integer limit, Integer offSet) {
        return customerDao.getLimitedCustomers(limit, offSet);
    }

    public void addCustomer(String firstName, String lastName, String country, Integer postalCode, Integer phone, String email) {
        customerDao.addCustomer(firstName, lastName, country, postalCode, phone, email);
    }

    public void updateCustomer(String firstName, String lastName, String country, Integer postalCode, Integer phone, String email, Integer id) {
        customerDao.updateCustomer(firstName, lastName, country, postalCode, phone, email, id);
    }

    public HashMap<String, Integer> getNumberOfCustomerByCountry() {
        return customerDao.getNumberOfCustomerByCountry();
    }

    public HashMap<String, Integer> getHighestSpenders() {
        return customerDao.getHighestSpenders();
    }

    public String getFavouriteGenre(String firstName) {
        return customerDao.getFavouriteGenre(firstName);
    }
}
