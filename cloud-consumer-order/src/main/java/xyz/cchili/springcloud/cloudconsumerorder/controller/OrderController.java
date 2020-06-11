package xyz.cchili.springcloud.cloudconsumerorder.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xyz.cchili.springcloud.cloudapicommons.pojo.Payment;
import xyz.cchili.springcloud.cloudapicommons.vo.Result;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/8 14:38
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderController {

    //private static final String URL = "http://localhost:8001";

    private static final String URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result create(Payment payment) {
        return restTemplate.postForObject(URL + "payment/create", payment, Result.class);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL + "/payment/get/" + id, Result.class);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result getEntity(@PathVariable("id") Long id) {
        ResponseEntity<Result> result = restTemplate.getForEntity(URL + "/payment/get/" + id, Result.class);
        log.info(String.valueOf(result.getStatusCode()));
        log.info(String.valueOf(result.getHeaders()));
        if (result.getStatusCode().is2xxSuccessful()) {
            return result.getBody();
        } else {
            return new Result(false);
        }
    }

    @GetMapping(value = "/port", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result port() {
        return restTemplate.getForObject(URL + "/payment/port", Result.class);
    }

    @GetMapping(value = "/discovery", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("==={}===", service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return discoveryClient;
    }
}
