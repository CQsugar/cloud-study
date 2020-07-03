package xyz.cchili.springcloud.account.service;

import xyz.cchili.springcloud.account.vo.Result;

public interface TAccountService {

    Result decrease(Long userId, Long money);
}
