package xyz.cchili.springcloud.service;

import xyz.cchili.springcloud.pojo.Payment;
import xyz.cchili.springcloud.vo.Result;

public interface PaymentService{

    Result create(Payment payment);

    Result getPaymentById(Long id);
}
