package com.wj.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

/**
 * @author WJ
 * @className: HealthStatusService
 * @description: 服务健康状态
 * @date 2021/12/27 21:39
 */
@Service
public class HealthStatusService implements HealthIndicator {

    private Boolean status = true;

    public String getStatus() {
        return this.status.toString();
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public Health health() {
        if(this.status){
            return new Health.Builder().up().build();
        }else{
            return new Health.Builder().down().build();
        }
    }
}
