package xyz.cchili.springcloud.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/29 13:57
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("xyz.cchili.springcloud.orderservice.mapper")
@EnableFeignClients
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class);
    }
}
