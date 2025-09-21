package com.heima.app.gateway;


import org.checkerframework.checker.signedness.qual.SignedPositive;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Meric
 * @CreateTime: 2025-09-19
 * @Description:
 * @Version: 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
public class APPGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(APPGatewayApplication.class, args);
    }
}
