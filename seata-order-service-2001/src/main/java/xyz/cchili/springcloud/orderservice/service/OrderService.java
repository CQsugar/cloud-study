package xyz.cchili.springcloud.orderservice.service;

import xyz.cchili.springcloud.orderservice.pojo.TOrder;

public interface OrderService {

    /**
     * 新建订单
     *
     * @param tOrder 订单
     **/
    void create(TOrder tOrder);

    /**
     * 修改订单
     */
    void update(TOrder tOrder);
}
