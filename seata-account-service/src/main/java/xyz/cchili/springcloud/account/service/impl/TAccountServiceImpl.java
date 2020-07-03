package xyz.cchili.springcloud.account.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import xyz.cchili.springcloud.account.mapper.TAccountMapper;
import xyz.cchili.springcloud.account.pojo.TAccount;
import xyz.cchili.springcloud.account.service.TAccountService;
import xyz.cchili.springcloud.account.vo.Result;

import javax.annotation.Resource;

@Service
@Slf4j
public class TAccountServiceImpl implements TAccountService {

    @Resource
    private TAccountMapper tAccountMapper;

    @Override
    public Result decrease(Long userId, Long money) {
        log.info("userId:{},money:{}", userId, money);
        Example example = new Example(TAccount.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        TAccount tAccount = tAccountMapper.selectOneByExample(example);
        tAccount.setUsed(tAccount.getUsed() + money);
        tAccount.setResidue(tAccount.getTotal() - tAccount.getUsed());
        tAccountMapper.updateByPrimaryKey(tAccount);
        return new Result<>(true, "扣减成功");
    }
}
