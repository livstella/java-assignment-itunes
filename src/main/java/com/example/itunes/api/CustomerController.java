package com.example.itunes.api;

import com.example.itunes.model.Customer;
import com.example.itunes.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path="{id}")
    public Customer getCustomerByID(@PathVariable("id") Integer id) {
        return customerService.getCustomerByID(id);
    }

    @GetMapping(path="name/{firstName}")
    public Customer getCustomerByName(@PathVariable("firstName") String firstName) {
        return customerService.getCustomerByName(firstName);
    }

    @GetMapping(path="limit/{limit}/{offSet}")
    public List<Customer> getLimitedCustomers(@PathVariable("limit") Integer limit,@PathVariable("offSet") Integer offSet) {
        return customerService.getLimitedCustomer(limit, offSet);
    }

    @PostMapping
    public void addCustomer(String firstName, String lastName, String country, Integer postalCode, Integer phone, String email) {
        customerService.addCustomer(firstName, lastName, country, postalCode, phone, email);
    }

    @PutMapping(path="{id}")
    public void updateCustomer(String firstName, String lastName, String country, Integer postalCode, Integer phone, String email,@PathVariable("id") Integer id) {
        customerService.updateCustomer(firstName, lastName, country, postalCode, phone, email, id);
    }

    @GetMapping(path="country")
    public HashMap<String, Integer> getNumberOfCustomerByCountry() {
        return customerService.getNumberOfCustomerByCountry();
    }

    @GetMapping(path="highest")
    public HashMap<String, Integer> getHighestSpenders() {
        return customerService.getHighestSpenders();
    }

    @GetMapping(path="favourite/{firstName}")
    public String getFavouriteGenre(@PathVariable("firstName") String firstName) {
        return customerService.getFavouriteGenre(firstName);
    }
}
