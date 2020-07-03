package xyz.cchili.springcloud.storage.service;

import xyz.cchili.springcloud.storage.vo.Result;

public interface TStorageService {

    Result decrease(Long productId, Integer count);
}
