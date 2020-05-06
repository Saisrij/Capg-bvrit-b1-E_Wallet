package com.capg.ewallet.fundtransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
public class EwalletFundTransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(EwalletFundTransferApplication.class, args);
	}

}
