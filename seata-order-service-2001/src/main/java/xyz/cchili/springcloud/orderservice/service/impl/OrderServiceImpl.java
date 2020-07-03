package xyz.cchili.springcloud.orderservice.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import xyz.cchili.springcloud.orderservice.mapper.TOrderMapper;
import xyz.cchili.springcloud.orderservice.pojo.TOrder;
import xyz.cchili.springcloud.orderservice.service.AccountService;
import xyz.cchili.springcloud.orderservice.service.OrderService;
import xyz.cchili.springcloud.orderservice.service.StorageService;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private TOrderMapper orderMapper;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "song_tx_group", rollbackFor = Exception.class)
    public void create(TOrder tOrder) {
        log.info("---------->创建订单");
        tOrder.setStatus(0);
        orderMapper.insert(tOrder);

        log.info("----------->订单微服务开始调用库存，做扣减count");
        storageService.decrease(tOrder.getProductId(), tOrder.getCount());
        log.info("----------->订单微服务开始调用库存，做扣减end");

        log.info("----------->订单微服务开始调用账户，做扣减money");
        accountService.decrease(tOrder.getUserId(), tOrder.getMoney());
        log.info("----------->订单微服务开始调用账户，做扣减end");

        log.info("----------->修改订单状态");
        tOrder.setStatus(1);
        update(tOrder);
        log.info("----------->修改订单状态end");

        log.info("----------->下订单end");
    }

    @Override
    public void update(TOrder tOrder) {
        Example example = new Example(TOrder.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", tOrder.getUserId());
        orderMapper.updateByExampleSelective(tOrder, example);
    }
}
