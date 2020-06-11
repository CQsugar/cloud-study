package xyz.cchili.springcloud.cloudconsumerorder.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/8 14:46
 */
@Configuration
public class WebConfiguration {

    @Bean
    //开启默认负载均衡机制
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
