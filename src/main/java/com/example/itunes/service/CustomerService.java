package com.example.itunes.service;

import com.example.itunes.dao.CustomerDao;
import com.example.itunes.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public void getCustomerByID(Integer id) {
        return customerDao.getCustomerByID(id);
    }

    public void getCustomerByName(String name) {
        return customerDao.getCustomerByName(name);
    }

    public List<Customer> getLimitedCustomer(Integer limit, Integer offSet) {
        return customerDao.getLimitedCustomer(limit, offSet);
    }

    public void addCustomer(String firstName, String lastName, String country, Integer postalCode, Integer phone, String email) {
        return customerDao.addCustomer(firstName, lastName, country, postalCode, phone, email);
    }

    public void updateCustomer(Integer id, Customer customer) {
        customerDao.updateCustomer(id, customer);
    }

    public List<Country> getCustomerAmountPerCountry() {
        return customerDao.getCustomerAmountPerCountry();
    }

    public List<Customer> getHighestSpenders() {
        return customerDao.getHighestSpenders();
    }

    public List<Customer> getMostPopularGenre() {
        return customerDao.getMostPopularGenre();
    }
}
