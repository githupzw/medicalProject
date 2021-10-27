package com.zwsyd.medical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>智慧医疗信息平台 - 系统基础服务功能启动类</b>
 * @author ZhangWei
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class MedicalSystemConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(MedicalSystemConsumerStarter.class, args);
	}
}
