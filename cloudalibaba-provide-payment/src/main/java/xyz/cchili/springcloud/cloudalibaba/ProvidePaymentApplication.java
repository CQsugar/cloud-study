package xyz.cchili.springcloud.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/23 9:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProvidePaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProvidePaymentApplication.class);
    }
}
