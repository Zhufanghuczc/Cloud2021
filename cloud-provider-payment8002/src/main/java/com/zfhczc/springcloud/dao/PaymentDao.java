package com.zfhczc.springcloud.dao;

import com.zfhczc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 支付资源 数据访问层接口
 * */
@Mapper
public interface PaymentDao {

    /**
     * 添加支付记录
     * @param payment
     * @return 数据库受影响行数
     * */
    int create(Payment payment);

    /**
     * 根据 id 获取一条支付信息
     * @param id
     * @return 数据库受影响行数
     * */
    Payment getPaymentById(@Param("id") Long id);
}
