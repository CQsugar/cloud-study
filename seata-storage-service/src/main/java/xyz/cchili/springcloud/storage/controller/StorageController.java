package xyz.cchili.springcloud.storage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cchili.springcloud.storage.service.TStorageService;
import xyz.cchili.springcloud.storage.vo.Result;

import javax.annotation.Resource;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/29 18:14
 */
@RestController
@Slf4j
public class StorageController {

    @Resource
    private TStorageService storageService;

    @PostMapping("/storage/decrease")
    public Result decrease(Long productId, Integer count) {
        try {
            storageService.decrease(productId, count);
        } catch (Exception e) {
            log.error("{}", e.getMessage());
            return new Result<>(false, "扣减失败");

        }

        return new Result<>(true, "扣减成功");

    }
}
