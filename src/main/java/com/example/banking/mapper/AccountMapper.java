package com.example.banking.mapper;

import com.example.banking.dto.AccountDto;
import com.example.banking.entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accountDto) { // Converts AccountDto into Account JPA entity
		Account account = new Account(
				accountDto.getId(),
				accountDto.getAccHolderName(),
				accountDto.getBalance(),
				accountDto.getUsername(),
				accountDto.getPassword(),
				accountDto.getAddress(),
				accountDto.getEmail(),
				accountDto.getPhone()
		);
		return account;
	}
	
	
	public static AccountDto mapToAccountDto(Account account) { // Converts Account JPA entity into AccountDto
		AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getAccHolderName(),
				account.getBalance(),
				account.getUsername(),
				account.getPassword(),
				account.getAddress(),
				account.getEmail(),
				account.getPhone()
		);
		return accountDto;
	}

}
