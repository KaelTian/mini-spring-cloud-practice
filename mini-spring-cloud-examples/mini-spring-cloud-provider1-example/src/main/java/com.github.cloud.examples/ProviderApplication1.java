package com.github.cloud.examples;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@SpringBootApplication
public class ProviderApplication1 {
    @Value("${random.int[20000,30000]}")
    private Integer port;

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication1.class, args);
    }

    @PostMapping("/echo1")
    public String echo() {
        return "我是丛围,我的端口是: " + port;
    }
}
