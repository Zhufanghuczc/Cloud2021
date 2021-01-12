package com.zfhczc.springcloud.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerTestController {

    public static final String PAYMENT_URL = "http://consoul-provider-payment";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/test")
    public String ConsumerTest(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }
}
