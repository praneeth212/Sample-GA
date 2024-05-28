package com.example.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.banking.dto.AccountDto;
import com.example.banking.service.AccountService;

@SpringBootApplication
public class BankingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}

}
