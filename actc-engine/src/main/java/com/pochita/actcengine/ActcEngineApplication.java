package com.pochita.actcengine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pochita.actcengine.mapper")
public class ActcEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActcEngineApplication.class, args);
    }

}
