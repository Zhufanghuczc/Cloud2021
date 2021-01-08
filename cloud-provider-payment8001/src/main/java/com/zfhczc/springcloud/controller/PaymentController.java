package com.zfhczc.springcloud.controller;

import com.zfhczc.springcloud.service.PaymentService;
import com.zfhczc.springcloud.entities.CommonResult;
import com.zfhczc.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("插入数据成功，数据库受影响行数:"+result);

        if (result > 0){
            return new CommonResult(200,"success",result);
        } else {
            return new CommonResult(444, "插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("数据库返回的支付资源实体:"+payment);

        if (payment != null){
            return new CommonResult(200,"success",payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询 ID："+id,null);
        }
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String Test(){
        return "Hello,world!";
    }
}
