package com.zfhczc.springcloud.service.impl;

import com.zfhczc.springcloud.dao.PaymentDao;
import com.zfhczc.springcloud.service.PaymentService;
import com.zfhczc.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Payment 业务逻辑层 实现类
 * */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
