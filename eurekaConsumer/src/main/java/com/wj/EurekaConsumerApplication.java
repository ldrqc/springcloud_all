package com.wj;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.wj.config.LoadBalancerConfig;
import com.wj.config.RibbonLoadBalancerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@LoadBalancerClients(defaultConfiguration = {LoadBalancerConfig.class})
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = RibbonLoadBalancerConfig.class)
public class EurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

    @Bean
//    @LoadBalanced
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public IRule getRandomRule(){
//        return new RandomRule();
//    }

}
