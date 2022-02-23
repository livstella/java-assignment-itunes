package com.example.itunes.api;

import com.example.itunes.model.Customer;
import com.example.itunes.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public void getCustomerByID(Integer id) {
        customerService.getCustomerByID(id);
    }

    public void getCustomerByName(String name) {
        customerService.getCustomerByName(name);
    }

    public List<Customer> getLimitedCustomers(Integer limit, Integer offSet) {
        return customerService.getLimitedCustomer(limit, offSet);
    }

    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
    }

    public void updateCustomer(Integer id, Customer customer) {
        customerService.updateCustomer(id, customer);
    }

    public List<Country> getCustomerAmountPerCountry() {
        return customerService.getCustomerAmountPerCountry();
    }

    public List<Customer> getHighestSpenders() {
        return customerService.getHighestSpenders();
    }

    public List<Customer> getMostPopularGenre() {
        return customerService.getMostPopularGenre();
    }
}
