package com.buzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getNames")
    public List<String> getNames() {
        //通过loadBalancerClient的choose函数来负载均衡的选出一个eureka-client的服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-service");
        //这个服务实例的基本信息存储在ServiceInstance中，然后通过这些对象中的信息拼接出访问/test/getNames接口的详细地址，最后再利用RestTemplate对象实现对服务提供者接口的调用。
        String url = "http://" + serviceInstance.getHost() + ":" +serviceInstance.getPort() + "/test/getNames";
        System.out.println("consumer  url=" + url);
        return restTemplate.getForObject(url, List.class);
    }
}
