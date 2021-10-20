package com.zwsyd.medical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <b>智慧医疗信息平台 - 注册中心启动类</b>
 * @author 张伟
 * @version 1.0.0
 */
@EnableEurekaServer
@SpringBootApplication
public class medicalRegistryStarter {
	public static void main(String[] args) {
		SpringApplication.run(medicalRegistryStarter.class, args);
	}
}
