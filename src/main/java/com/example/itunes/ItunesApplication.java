package com.example.itunes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.List;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
public class ItunesApplication {



    public static void main(String[] args) {
        SpringApplication.run(ItunesApplication.class, args);

        Connection conn=ConnectionManager.getInstance().getConnection();




        try {
            PreparedStatement preparedStatement =conn.prepareStatement("SELECT Name  from main.Genre WHERE GenreId=1");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                System.out.printf(resultSet.getString("Name"));
            }

            conn.close();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            System.exit(-1);
        }




    }

    @GetMapping
    public List<String> test(){
        return List.of("Hello, World");
    }

}
