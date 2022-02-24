package com.example.itunes;

import com.example.itunes.dao.CustomerDataAccessService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//Without the last argument, it fails to run
//https://stackoverflow.com/questions/51221777/failed-to-configure-a-datasource-url-attribute-is-not-specified-and-no-embedd
public class ItunesApplication {

    public static void main(String[] args) {

        SpringApplication.run(ItunesApplication.class, args);

        CustomerDataAccessService x= new CustomerDataAccessService();

       // x.getAllCustomers();
        x.getCustomerByID(63);
        //x.getCustomerByName("Trunte");
       // x.getNumberOfCustomerByCountry();*/
       // x.getHighestSpenders();

       // x.getFavouriteGenre("luis");

   //x.updateCustomer("Doggo","STick","Denmark", 1234,1234556, "trunte@sticks.com",63);


    }

    @GetMapping
    public List<String> test(){
        return List.of("Hello, World");*/
    }

}
