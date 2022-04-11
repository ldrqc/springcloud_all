package com.wj.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @author WJ
 * @className: LoadBalancerConfig
 * @description: springcloud loadBalancer 自定义负载
 * @date 2022/1/8 13:20
 */
//@Configuration
public class RibbonLoadBalancerConfig {

    @Bean
    public IRule getRandomLoadBalancerRule(){
        return new RandomRule();
    }

}
