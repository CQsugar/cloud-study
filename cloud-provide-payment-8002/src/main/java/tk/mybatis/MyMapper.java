package tk.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/8 11:15
 */
public interface MyMapper<T> extends MySqlMapper<T>, Mapper<T> {
}
