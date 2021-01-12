package com.zfhczc.springcloud.controller;

import com.zfhczc.springcloud.entities.CommonResult;
import com.zfhczc.springcloud.entities.Payment;
import com.zfhczc.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("OrderFeignController ******************");
        return paymentFeignService.getPaymentById(id);
    }

}
