package xyz.cchili.springcloud.consumer.service.impl;

import org.springframework.stereotype.Component;
import xyz.cchili.springcloud.cloudapicommons.vo.Result;
import xyz.cchili.springcloud.consumer.service.PaymentService;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/23 15:25
 */
@Component
public class PaymentFallBack implements PaymentService {

    @Override
    public Result port(String name) {
        return new Result(false);
    }
}
