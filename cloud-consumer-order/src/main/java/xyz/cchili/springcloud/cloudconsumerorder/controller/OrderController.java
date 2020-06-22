package xyz.cchili.springcloud.cloudconsumerorder.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cchili.springcloud.cloudapicommons.vo.Result;
import xyz.cchili.springcloud.cloudconsumerorder.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/8 14:38
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
//该注解可指定整体的降级策略 但须下需降级的方法上显式的使用HystrixCommand注解
@DefaultProperties(defaultFallback = "back")
public class OrderController {


    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result getPayment(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping(value = "/port", produces = MediaType.APPLICATION_JSON_VALUE)
    @HystrixCommand
    public Result getPort() {
        //故意使程序报错
        int age = 1 / 0;
        return paymentService.port();
    }

    /**
     * HystrixCommand 该注解指定下面方法当访问时发生错误时返回回调的内容实现降级处理
     * HystrixProperty 中可指定超时时间
     */
    @GetMapping(value = "/port3", produces = MediaType.APPLICATION_JSON_VALUE)
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public Result getPort3() {
        return paymentService.port3();
    }

    public Result fallback() {
        return new Result<>(false, "超时");
    }

    public Result back() {
        return new Result<>(false, "异常");
    }
}
