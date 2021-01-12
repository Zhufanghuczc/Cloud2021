package com.zfhczc.springcloud.controller;

import com.zfhczc.springcloud.entities.CommonResult;
import com.zfhczc.springcloud.entities.Payment;
import com.zfhczc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("插入数据成功，数据库受影响行数:"+result);

        if (result > 0){
            return new CommonResult(200,"success",result+"当前提供者："+serverPort);
        } else {
            return new CommonResult(444, "插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("数据库返回的支付资源实体:"+payment);

        if (payment != null){
            return new CommonResult(200,"success",payment+"当前提供者："+serverPort);
        } else {
            return new CommonResult(444, "没有对应记录，查询 ID："+id,null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){

        List<String> serviceList = discoveryClient.getServices();
        for (String s : serviceList) {
            log.info("服务清单："+s);
        }

        List<ServiceInstance> instanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instanceList) {
            log.info("实例："+instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String Test(){
        return "Hello,world!";
    }
}
