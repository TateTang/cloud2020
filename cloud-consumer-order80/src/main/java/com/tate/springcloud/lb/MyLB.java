package com.tate.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author tangmf
 * @Date 2021/3/15 8:39 下午
 * @Description
 */
@Component //使得Spring容器能够扫描到
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);//原子类

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        // 下标 = 第几次请求数 % 服务器集群总数量 = 1 % 2
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);//获取到那个服务器调用
    }

    /**
     * 获取到第几次访问数，也就是当前的rest接口请求的接口数
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();//初始值
            //整型的最大值，大于最大值就需要重置为0，重新进行计数
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        //自旋锁取到想要的值
        System.out.println("*****第几次访问次数：next:" + next);
        return next;
    }
}
