package xyz.cchili.springcloud.cloudconsumerorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import xyz.cchili.springcloud.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class CloudConsumerOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderApplication.class, args);
    }

}
