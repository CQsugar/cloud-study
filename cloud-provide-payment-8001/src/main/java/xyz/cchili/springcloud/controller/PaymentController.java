package xyz.cchili.springcloud.controller;

import org.springframework.web.bind.annotation.*;
import xyz.cchili.springcloud.pojo.Payment;
import xyz.cchili.springcloud.service.PaymentService;
import xyz.cchili.springcloud.vo.Result;
import xyz.cchili.springcloud.vo.ResultCode;

import javax.annotation.Resource;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/8 11:50
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/create")
    public Result create(Payment payment){
        try {
            return paymentService.create(payment);
        }catch (Exception e){
            return new Result(false, ResultCode.COMMON_FAIL);
        }
    }

    @GetMapping("/get/{id}")
    public Result PaymentById(@PathVariable("id") Long id){
        try {
            return paymentService.getPaymentById(id);
        }catch (Exception e){
            return new Result(false, ResultCode.COMMON_FAIL);
        }
    }
}
