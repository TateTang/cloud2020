package com.tate.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author tangmf
 * @Date 2021/5/7 8:10 下午
 * @Description
 */
@Mapper
public interface AccountDao {
    int decrease(@Param("userId") Long userId,
                 @Param("money") BigDecimal money);
}
