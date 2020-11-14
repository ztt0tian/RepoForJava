package com.example.boot20201114;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.boot20201114.mapper")
public class Boot20201114Application {

    public static void main(String[] args) {
        SpringApplication.run(Boot20201114Application.class, args);
    }

}
