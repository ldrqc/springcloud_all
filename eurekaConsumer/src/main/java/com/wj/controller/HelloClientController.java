package com.wj.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * @author WJ
 * @className: HelloClientController
 * @description: hello
 * @date 2021/12/18 18:23
 */
@RestController
public class HelloClientController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("/hello")
    public String hello(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        return  "hello client";
    }

    @GetMapping("/hello1")
    public Object getClient(){
        List<ServiceInstance> instances = discoveryClient.getInstances("eurekaProvide");
        return  instances;
    }

//    @GetMapping("/hello2")
    public String getProvide(){
//        List<InstanceInfo> instances = eurekaClient.getInstancesById("LAPTOP-44B5IH5Q:eurekaProvide:8080");
        List<InstanceInfo> instances = eurekaClient.getInstancesByVipAddress("EUREKAPROVIDE", false);

       if(instances.size()>0){
           InstanceInfo instanceInfo = instances.get(0);
           String url = "http://"+instanceInfo.getHostName()+":"+instanceInfo.getPort()+"/hello";
           System.out.println(url);

           RestTemplate restTemplate = new RestTemplate();
           String forObject = restTemplate.getForObject(url, String.class);
           System.out.println(forObject);
       }

        return "hello2";
    }


    @GetMapping("/hello3")
    public String getProvideLoadBalanced() throws IOException {
//     完成客户端的负载均衡  并且过滤掉了  服务状态为down的服务
       ServiceInstance eurekaprovide = loadBalancerClient.choose("EUREKAPROVIDE");

       String url = "http://"+eurekaprovide.getHost()+":"+eurekaprovide.getPort()+"/hello";
       System.out.println(url);

       RestTemplate restTemplate = new RestTemplate();
       String forObject = restTemplate.getForObject(url, String.class);
       System.out.println(forObject);

        return "hello3";
    }
}
