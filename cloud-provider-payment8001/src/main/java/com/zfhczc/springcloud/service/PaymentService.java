package com.zfhczc.springcloud.service;

import com.zfhczc.springcloud.entities.Payment;

/**
 * 支付资源 业务逻辑层接口
 * */
public interface PaymentService {

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
    Payment getPaymentById(Long id);
}
