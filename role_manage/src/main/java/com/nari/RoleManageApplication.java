package com.nari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoleManageApplication {

    //模块之间是怎么通信交互通信的 先把数据库建起来
    public static void main(String[] args) {
        SpringApplication.run(RoleManageApplication.class, args);
    }

}
