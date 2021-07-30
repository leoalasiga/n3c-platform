package com.n3c.configcenter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljj
 * @description
 * @date 2021-07-29
 */
@RestController
@RefreshScope
public class Hello {

    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private int age;

    @GetMapping("/hello")
    public String hello() {
        return "hello , " + name;
    }
}
