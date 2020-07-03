package xyz.cchili.springcloud.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/29 18:25
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("xyz.cchili.springcloud.account.mapper")
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class);
    }
}
