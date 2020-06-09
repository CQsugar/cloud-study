package xyz.cchili.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("xyz.cchili.springcloud.mapper")
@EnableEurekaClient
public class CloudProvidePayment8002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProvidePayment8002Application.class, args);
    }

}
