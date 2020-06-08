package xyz.cchili.springcloud.cloudconsumerorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xyz.cchili.springcloud.cloudconsumerorder.pojo.Payment;
import xyz.cchili.springcloud.cloudconsumerorder.vo.Result;

import javax.annotation.Resource;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/8 14:38
 */
@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

    private static final String URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/create")
    public Result create(Payment payment) {
        return restTemplate.postForObject(URL + "payment/create", payment, Result.class);
    }

    @GetMapping("/get/{id}")
    public Result getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL + "/payment/get/" + id, Result.class);
    }
}
