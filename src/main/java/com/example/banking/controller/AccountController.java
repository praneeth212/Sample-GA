package com.example.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.dto.AccountDto;
import com.example.banking.entity.Account;
import com.example.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	// Get All Accounts REST API
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accounts = accountService.getAllAccounts();
		return ResponseEntity.ok(accounts);
	}
	
	// Get Account REST API
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		AccountDto accountDto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto); // ok method internally returns HTTP status to 100 OK
	}
	
	// Add Account REST API
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}
	
	// Deposit REST API
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
		
		Double amount = request.get("amount");
		
		AccountDto accountDto = accountService.deposit(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	
	// Withdraw REST API
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
		Double amount = request.get("amount");
		
		AccountDto accountDto = accountService.withdraw(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	
	// Update Account REST API
	@PutMapping("update/{id}")
	public ResponseEntity<AccountDto> updateAccount(@PathVariable Long id, @RequestBody AccountDto accountDto){
		AccountDto updatedAccount = accountService.updateAccount(id, accountDto);
		return ResponseEntity.status(HttpStatus.OK).body(updatedAccount);
	}
	
	// Delete Account REST API
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account is deleted successfully!");
	}
	
	// Checking Balance REST API
	@GetMapping("/{id}/balance")
	public ResponseEntity<Double> checkBalance(@PathVariable Long id){
		double balance = accountService.checkBalance(id);
		return ResponseEntity.ok(balance);
	}
	
	// Login REST API
	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody AccountDto accountDto){
		boolean loggedIn = accountService.login(accountDto.getId(), accountDto.getUsername(), accountDto.getPassword());
		System.out.println(accountDto.getUsername()+" Logged In");
		return ResponseEntity.ok(loggedIn);
	}
	
	
	 @PutMapping("/{id}/change-password")
	    public ResponseEntity<Boolean> changePassword(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
	        String oldPassword = requestBody.get("oldPassword");
	        String newPassword = requestBody.get("newPassword");

	        // Call the service method to change password
	        boolean passwordChanged = accountService.changePassword(id, oldPassword, newPassword);

	        if (passwordChanged) {
	            // Password changed successfully
	            return ResponseEntity.status(HttpStatus.OK).body(true);
	        } else {
	            // Password change failed (old password mismatch)
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
	        }
	    }
	
	
	@PutMapping("/{id}/edit-profile")
    public ResponseEntity<AccountDto> editProfile(@PathVariable Long id, @RequestBody AccountDto accountDto) {
        // Call the service method to edit profile
        AccountDto updatedAccount = accountService.editProfile(id, accountDto);
        
        // Return the updated account as ResponseEntity
        return ResponseEntity.status(HttpStatus.OK).body(updatedAccount);
    }

}