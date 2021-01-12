package com.zfhczc.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer {

    // 原子类
    private AtomicInteger atomicInteger = new AtomicInteger();

    // 得到
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 214748647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("=====当前第几次访问？: "+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int i = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(i);
    }
}
