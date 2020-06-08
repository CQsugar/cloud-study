package xyz.cchili.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("xyz.cchili.springcloud.mapper")
public class CloudProvidePayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProvidePayment8001Application.class, args);
    }

}
