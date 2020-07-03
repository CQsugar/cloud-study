package xyz.cchili.springcloud.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.cchili.springcloud.orderservice.vo.Result;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/29 15:07
 */
@FeignClient("seata-storage")
public interface StorageService {

    @PostMapping("/storage/decrease")
    Result decrease(@RequestParam Long productId, @RequestParam Integer count);
}
