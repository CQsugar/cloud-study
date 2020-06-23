package xyz.cchili.springcloud.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.cchili.springcloud.cloudapicommons.vo.Result;
import xyz.cchili.springcloud.consumer.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/23 15:28
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/port/{name}")
    public Result getPort(@PathVariable String name) {
        return paymentService.port(name);
    }
}
