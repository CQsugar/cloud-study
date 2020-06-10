package xyz.cchili.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("xyz.cchili.springcloud.mapper")
@EnableDiscoveryClient //该注解用于向使用者consul zookeeper作为注册中心时注册服务
public class CloudProvidePayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProvidePayment8001Application.class, args);
    }

}
