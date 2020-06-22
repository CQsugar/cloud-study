package xyz.cchili.springcloud.cloudstreamconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/21 19:00
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStreamConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamConsumerApplication.class);
    }
}
