package xyz.cchili.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.cchili.springcloud.cloudapicommons.pojo.Payment;
import xyz.cchili.springcloud.cloudapicommons.vo.Result;
import xyz.cchili.springcloud.cloudapicommons.vo.ResultCode;
import xyz.cchili.springcloud.mapper.PaymentMapper;
import xyz.cchili.springcloud.service.PaymentService;

import javax.annotation.Resource;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public Result create(Payment payment) {
        int insert = paymentMapper.insert(payment);
        if (insert > 0) {
            log.info("创建成功");
            return new Result<>(true);
        } else {
            log.info("创建失败");
            return new Result<>(false);
        }
    }

    @Override
    public Result getPaymentById(Long id) {
        Payment payment = paymentMapper.selectByPrimaryKey(id);
        if (ObjectUtil.isNotEmpty(payment)) {
            log.info("查询成功：{}", payment);
            return new Result<>(true, payment);
        } else {
            log.info("查询失败");
            return new Result<>(false, ResultCode.NO_DATA);
        }
    }

    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    @Override
    public Result hystrix(Long id) {
        if (id < 0) {
            throw new RuntimeException("不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return new Result<>(true, Thread.currentThread().getName() + ":" + uuid + "-" + id);
    }

    public Result fallback(Long id) {
        return new Result<>(false, "服务器超载");
    }

}
