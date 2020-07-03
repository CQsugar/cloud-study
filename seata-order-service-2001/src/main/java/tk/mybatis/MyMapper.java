package tk.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/29 14:07
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
