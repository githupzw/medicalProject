package com.zwsyd.medical;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>智慧医疗信息平台 - </b>
 */
@MapperScan("com.zwsyd.medical.*.*.dao")
@EnableEurekaClient
@SpringBootApplication
public class MedicalSystemProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(MedicalSystemProviderStarter.class, args);
	}
}
