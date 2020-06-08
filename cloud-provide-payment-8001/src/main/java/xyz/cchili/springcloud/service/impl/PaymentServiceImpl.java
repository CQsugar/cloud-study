package xyz.cchili.springcloud.service.impl;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.cchili.springcloud.mapper.PaymentMapper;
import xyz.cchili.springcloud.pojo.Payment;
import xyz.cchili.springcloud.service.PaymentService;
import xyz.cchili.springcloud.vo.Result;
import xyz.cchili.springcloud.vo.ResultCode;

import javax.annotation.Resource;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public Result create(Payment payment) {
        int insert = paymentMapper.insert(payment);
        if (insert > 0) {
            log.info("创建成功");
            return new Result<>(true);
        }else {
            log.info("创建失败");
            return new Result<>(false);
        }
    }

    @Override
    public Result getPaymentById(Long id) {
        Payment payment = paymentMapper.selectByPrimaryKey(id);
        if (ObjectUtil.isNotEmpty(payment)) {
            log.info("查询成功：{}",payment);
            return new Result<>(true, payment);
        } else {
            log.info("查询失败");
            return new Result<>(true, ResultCode.NO_DATA);
        }
    }
}
