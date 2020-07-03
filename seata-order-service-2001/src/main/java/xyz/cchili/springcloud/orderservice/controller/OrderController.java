package xyz.cchili.springcloud.orderservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cchili.springcloud.orderservice.pojo.TOrder;
import xyz.cchili.springcloud.orderservice.service.OrderService;
import xyz.cchili.springcloud.orderservice.vo.Result;

import javax.annotation.Resource;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/29 16:15
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/create")
    public Result create(TOrder order) {
        try {
            orderService.create(order);
        } catch (Exception e) {
            log.error("{}", e.getMessage());
            return new Result<>(false, "下订单失败");

        }

        return new Result<>(true, "下订单成功");
    }
}
