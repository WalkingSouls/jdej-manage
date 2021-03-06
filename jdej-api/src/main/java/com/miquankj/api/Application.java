package com.miquankj.api;

import com.miquankj.api.config.YamlProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by liuhangjun on 2018/2/4.
 */
@ServletComponentScan
@SpringBootApplication
public class Application implements CommandLineRunner {


    @Override
    public void run(String... args) {
        System.out.println();
        System.out.println("===================================================");
        System.out.println("---------------------------------------------------");
        System.out.println("Current project name : " + YamlProperties.getProperty("spring.application.name"));
        System.out.println("---------------------------------------------------");
        System.out.println("===================================================");
        System.out.println();
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
