package com.wj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WJ
 * @className: HelloController
 * @description: hello
 * @date 2021/12/18 11:02
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHello(){
        return "hello provide1";
    }
}
