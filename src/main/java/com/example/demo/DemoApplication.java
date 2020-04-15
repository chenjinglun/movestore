package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.jms.annotation.EnableJms;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableJms
@SpringBootApplication
@EnableTransactionManagement
@MapperScan({"com.example.demo.*.Dao","com.example.demo.*.dao"})
//@ComponentScan("com.example.demo.*.Dao")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        //System.setProperty("es.set.netty.runtime.available.processors", "false");
    }
}
