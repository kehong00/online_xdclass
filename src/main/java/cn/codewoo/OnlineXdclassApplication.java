package cn.codewoo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.codewoo.mapper")
public class OnlineXdclassApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineXdclassApplication.class, args);
    }

}
