package com.example.quality_inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuantityandInventoryModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuantityandInventoryModuleApplication.class, args);
	}

}
