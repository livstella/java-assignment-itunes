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
@RestController
public class ItunesApplication {



    public static void main(String[] args) {
        SpringApplication.run(ItunesApplication.class, args);

        CustomerDataAccessService x= new CustomerDataAccessService();
        x.getCustomerByID(2);



/*
        Connection conn=ConnectionManager.getInstance().getConnection();




        try {
            PreparedStatement preparedStatement =conn.prepareStatement("SELECT Name  from Genre WHERE Name LIKE ?");

            preparedStatement.setString(1,"Rock");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String genreName=resultSet.getString("Name");

                System.out.println(genreName);
            }

            conn.close();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            System.exit(-1);
        }

*/


    }

    @GetMapping
    public List<String> test(){
        return List.of("Hello, World");
    }

}
