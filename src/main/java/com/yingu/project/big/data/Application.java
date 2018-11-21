package com.yingu.project.big.data;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author huangkunhao
 * @date 2018/11/20
 * @Description
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.yingu.project.big.data.persistence.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("============= SpringBoot Start Success =============");
    }
}
