package com.capg.ewallet.fundtransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EwalletFundTransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(EwalletFundTransferApplication.class, args);
	}

}
