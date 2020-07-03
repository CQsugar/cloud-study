package xyz.cchili.springcloud.account.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cchili.springcloud.account.service.TAccountService;
import xyz.cchili.springcloud.account.vo.Result;

import javax.annotation.Resource;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/29 18:18
 */
@RestController
@Slf4j
public class AccountController {

    @Resource
    private TAccountService accountService;

    @PostMapping("/account/decrease")
    public Result decrease(Long userId, Long money) {
        try {
            Thread.sleep(3000);
            accountService.decrease(userId, money);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false, "扣减失败");

        }
        return new Result<>(true, "扣减成功");
    }
}
