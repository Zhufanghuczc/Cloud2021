package com.zfhczc.springcloud.controller;

import com.zfhczc.springcloud.entities.CommonResult;
import com.zfhczc.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderZkController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/zk")
    public String getPayment(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }

}
