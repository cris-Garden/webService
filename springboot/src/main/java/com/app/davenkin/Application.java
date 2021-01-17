package com.app.davenkin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//@SpringBootApplication(scanBasePackages = "com.app.co")
@SpringBootApplication
@MapperScan("com.app.mapper")
@ComponentScan({"com.app.conf","com.app.davenkin"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
