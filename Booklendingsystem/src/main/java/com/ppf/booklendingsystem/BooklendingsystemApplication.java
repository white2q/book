package com.ppf.booklendingsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.ppf.booklendingsystem.mapper")
@SpringBootApplication
public class BooklendingsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooklendingsystemApplication.class, args);
    }

}
