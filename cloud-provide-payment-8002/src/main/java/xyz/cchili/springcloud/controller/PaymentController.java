package xyz.cchili.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import xyz.cchili.springcloud.cloudapicommons.pojo.Payment;
import xyz.cchili.springcloud.cloudapicommons.vo.Result;
import xyz.cchili.springcloud.cloudapicommons.vo.ResultCode;
import xyz.cchili.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/8 11:50
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/port")
    public Result port() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Result(true, port);
    }

    @PostMapping("/create")
    public Result create(@RequestBody Payment payment) {
        try {
            return paymentService.create(payment);
        } catch (Exception e) {
            return new Result(false, ResultCode.COMMON_FAIL);
        }
    }

    @GetMapping("/get/{id}")
    public Result PaymentById(@PathVariable("id") Long id) {
        try {
            return paymentService.getPaymentById(id);
        } catch (Exception e) {
            return new Result(false, ResultCode.COMMON_FAIL);
        }
    }
}
