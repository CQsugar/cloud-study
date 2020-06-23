package xyz.cchili.springcloud.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.cchili.springcloud.cloudapicommons.vo.Result;
import xyz.cchili.springcloud.consumer.service.impl.PaymentFallBack;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/23 15:18
 */
@FeignClient(value = "alibaba-provide-payment", fallback = PaymentFallBack.class)
public interface PaymentService {

    @GetMapping(value = "/port/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    Result port(@PathVariable String name);
}
