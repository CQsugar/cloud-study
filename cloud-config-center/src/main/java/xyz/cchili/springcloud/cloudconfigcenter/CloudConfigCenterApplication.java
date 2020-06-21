package xyz.cchili.springcloud.cloudconfigcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/20 1:21
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenterApplication.class);
    }
}
