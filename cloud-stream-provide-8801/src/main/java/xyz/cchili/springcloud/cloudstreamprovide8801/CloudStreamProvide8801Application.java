package xyz.cchili.springcloud.cloudstreamprovide8801;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/21 17:19
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStreamProvide8801Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamProvide8801Application.class);
    }
}
