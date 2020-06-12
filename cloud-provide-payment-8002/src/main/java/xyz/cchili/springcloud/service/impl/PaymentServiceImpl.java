package xyz.cchili.springcloud.service.impl;

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
import java.util.concurrent.TimeUnit;

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
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public Result getPaymentById(Long id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Payment payment = paymentMapper.selectByPrimaryKey(id);
        if (ObjectUtil.isNotEmpty(payment)) {
            log.info("查询成功：{}", payment);
            return new Result<>(true, payment);
        } else {
            log.info("查询失败");
            return new Result<>(false, ResultCode.NO_DATA);
        }
    }

    public Result<String> fallback(Long id) {
        return new Result<>(true, "请求超时" + id);
    }
}
