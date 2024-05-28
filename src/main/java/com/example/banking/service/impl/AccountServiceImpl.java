package com.example.banking.service.impl;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.banking.dto.AccountDto;
import com.example.banking.entity.Account;
import com.example.banking.mapper.AccountMapper;
import com.example.banking.repository.AccountRepository;
import com.example.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	private AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist."));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist."));
		
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist."));
		
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insufficient Amount");
		}
		
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist."));
		
		accountRepository.deleteById(id);
	}

	@Override
	public boolean login(Long id, String username, String password) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist."));
		
		return account.getPassword().equals(password);
	}

	@Override
	public double checkBalance(Long id) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist."));
		return account.getBalance();
	}

	@Override
	public AccountDto editProfile(Long id, AccountDto accountDto) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist."));
		
		if (accountDto.getAccHolderName() != null) {
	        account.setAccHolderName(accountDto.getAccHolderName());
	    }
	    if (accountDto.getUsername() != null) {
	        account.setUsername(accountDto.getUsername());
	    }
	    if (accountDto.getAddress() != null) {
	        account.setAddress(accountDto.getAddress());
	    }
	    if (accountDto.getEmail() != null) {
	        account.setEmail(accountDto.getEmail());
	    }
	    if (accountDto.getPhone() != null) {
	        account.setPhone(accountDto.getPhone());
	    }
		
		
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto updateAccount(Long id, AccountDto accountDto) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist."));
		
		if (accountDto.getAccHolderName() != null) {
	        account.setAccHolderName(accountDto.getAccHolderName());
	    }
	    if (accountDto.getUsername() != null) {
	        account.setUsername(accountDto.getUsername());
	    }
	    if (accountDto.getPassword() != null) {
	        account.setPassword(accountDto.getPassword());
	    }
	    if (accountDto.getAddress() != null) {
	        account.setAddress(accountDto.getAddress());
	    }
	    if (accountDto.getEmail() != null) {
	        account.setEmail(accountDto.getEmail());
	    }
	    if (accountDto.getPhone() != null) {
	        account.setPhone(accountDto.getPhone());
	    }
	    
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public boolean changePassword(Long id, String oldPass, String newPass) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist."));
		
		if(!account.getPassword().equals(oldPass)) {
			return false;
		}
		account.setPassword(newPass);
		Account savedAccount = accountRepository.save(account);
		return true;
	}
	
	

}
