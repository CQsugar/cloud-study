package xyz.cchili.springcloud.cloudconsumerorder2.service.impl;

import org.springframework.stereotype.Component;
import xyz.cchili.springcloud.cloudapicommons.vo.Result;
import xyz.cchili.springcloud.cloudconsumerorder2.service.PaymentService;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/11 17:55
 */
@Component
public class PaymentFallBackServiceImpl implements PaymentService {

    @Override
    public Result getPaymentById(Long id) {
        return fallback();
    }

    @Override
    public Result port() {
        return fallback();
    }

    @Override
    public Result port3() {
        return fallback();
    }

    private Result fallback() {
        return new Result<>(false, "异常了...............");
    }
}
