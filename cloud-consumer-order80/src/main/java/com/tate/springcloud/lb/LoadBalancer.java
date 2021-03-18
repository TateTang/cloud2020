package com.tate.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author tangmf
 * @Date 2021/3/15 8:37 下午
 * @Description
 */
public interface LoadBalancer {


    /**
     * 获取当前的服务实例
     * @param serviceInstances 服务实例总数
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
