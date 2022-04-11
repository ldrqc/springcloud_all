package com.wj.controller;

import com.wj.service.HealthStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WJ
 * @className: HelloController
 * @description: hello
 * @date 2021/12/18 11:02
 */
@RestController
public class HelloController {


    @Autowired
    private HealthStatusService healthStatusService;

    @GetMapping("/hello")
    public String getHello(){
        return "hello provide2";
    }

    @GetMapping("/health")
    public String getStatus(@RequestParam("status") Boolean status){
        healthStatusService.setStatus(status);
        return healthStatusService.getStatus();
    }
}
