package com.example.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableJms
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
		System.out.println("Hello and welcome! b");

		// Press Shift+F10 or click the green arrow button in the gutter to run the code.
		for (int i = 1; i <= 5; i++) {

			// Press Shift+F9 to start debugging your code. We have set one breakpoint
			// for you, but you can always add more by pressing Ctrl+F8.
			System.out.println("i = " + i);
		}
	}

}
