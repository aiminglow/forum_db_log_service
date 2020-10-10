package com.aiming.low.forum_db_log_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aiming.low.forum_db_log_service.dao")
public class ForumDbLogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumDbLogServiceApplication.class, args);
    }

}
