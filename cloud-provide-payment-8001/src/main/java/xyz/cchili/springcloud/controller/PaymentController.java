package xyz.cchili.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
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
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/port3", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> port3() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("=======port3请求=========");
        return new Result<>(true, Thread.currentThread().getName() + ":" + port);
    }

    @GetMapping(value = "/port", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> port() {
        log.info("=======port请求=========");
        return new Result<>(true, Thread.currentThread().getName() + ":" + port);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result create(@RequestBody Payment payment) {
        try {
            return paymentService.create(payment);
        }catch (Exception e){
            return new Result(false, ResultCode.COMMON_FAIL);
        }
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result paymentById(@PathVariable("id") Long id) {
        try {
            return paymentService.getPaymentById(id);
        }catch (Exception e){
            return new Result(false, ResultCode.COMMON_FAIL);
        }
    }
}
