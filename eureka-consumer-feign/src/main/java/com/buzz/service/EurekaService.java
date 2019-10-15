package com.buzz.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("eureka-client") //指定这个接口所要调用的服务名称,接口中定义的各个函数使用Spring MVC的注解就可以来绑定服务提供方的REST接口
public interface EurekaService {

    // 绑定eureka-client服务的/test/getNames接口
    @GetMapping("/test/getNames")
    List<String> getNames();
}
