package com.example.banking.service;

import java.util.List;

import com.example.banking.dto.AccountDto;

public interface AccountService {
	
	// Admin methods
	AccountDto createAccount(AccountDto accountDto); // Creating Account - Working
	
	List<AccountDto> getAllAccounts(); // Getting all Accounts - Working
	
	AccountDto getAccountById(Long id); // Retrieving Account using ID - Working
	
	AccountDto updateAccount(Long id, AccountDto accountDto); // Updating Account - working
	
	void deleteAccount(Long id); // Deleting Account using ID - working
	
	// Customer methods
	AccountDto deposit(Long id, double amount); // Depositing Money - working
	
	AccountDto withdraw(Long id, double amount); // Withdrawing Money - working
	
	boolean login(Long id, String username, String password); // Login - working
	
	double checkBalance(Long id); // Checking Balance - working
	
	AccountDto editProfile(Long id, AccountDto accountDto); // Editing Profile - working
	
	boolean changePassword(Long id, String oldPass, String newPass); // Changing Password - working
	
}