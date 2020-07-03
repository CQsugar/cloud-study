package xyz.cchili.springcloud.storage.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import xyz.cchili.springcloud.storage.mapper.TStorageMapper;
import xyz.cchili.springcloud.storage.pojo.TStorage;
import xyz.cchili.springcloud.storage.service.TStorageService;
import xyz.cchili.springcloud.storage.vo.Result;

import javax.annotation.Resource;

@Service
@Slf4j
public class TStorageServiceImpl implements TStorageService {

    @Resource
    private TStorageMapper tStorageMapper;


    @Override
    public Result decrease(Long productId, Integer count) {
        log.info("productId:{},count:{}", productId, count);
        Example example = new Example(TStorage.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId", productId);
        TStorage tStorage = tStorageMapper.selectOneByExample(example);
        tStorage.setUsed(tStorage.getUsed() + count);
        tStorage.setResidue(tStorage.getTotal() - tStorage.getUsed());
        tStorageMapper.updateByPrimaryKeySelective(tStorage);
        return new Result<>(true, "扣减成功");
    }
}
