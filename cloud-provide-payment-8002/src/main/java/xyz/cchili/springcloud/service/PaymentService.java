package xyz.cchili.springcloud.service;


import xyz.cchili.springcloud.cloudapicommons.pojo.Payment;
import xyz.cchili.springcloud.cloudapicommons.vo.Result;

public interface PaymentService {

    Result create(Payment payment);

    Result getPaymentById(Long id);
}
