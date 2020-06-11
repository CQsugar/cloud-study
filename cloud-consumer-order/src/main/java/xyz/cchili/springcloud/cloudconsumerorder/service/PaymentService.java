package xyz.cchili.springcloud.cloudconsumerorder.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.cchili.springcloud.cloudapicommons.vo.Result;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/11 10:54
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping(value = "/payment/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Result getPaymentById(@PathVariable Long id);

    @GetMapping(value = "/payment/port", produces = MediaType.APPLICATION_JSON_VALUE)
    Result port();

}
