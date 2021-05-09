package com.tate.springcloud.dao;

import com.tate.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author tangmf
 * @Date 2021/5/6 9:17 下午
 * @Description
 */
@Mapper
public interface OrderDao {
    //1 新建订单
    void create(Order order);

    //2 修改订单状态
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
