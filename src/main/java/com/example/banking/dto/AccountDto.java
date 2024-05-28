package com.example.banking.dto;

import lombok.Data;

@Data

public class AccountDto {
	private Long id;
	private String accHolderName;
	private double balance;
	
	private String username;
	private String password;
	private String address;
	private String email;
	private String phone;
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDto(Long id, String accHolderName, double balance, String username, String password, String address,
			String email, String phone) {
		super();
		this.id = id;
		this.accHolderName = accHolderName;
		this.balance = balance;
		this.username = username;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "AccountDto [id=" + id + ", accHolderName=" + accHolderName + ", balance=" + balance + ", username="
				+ username + ", password=" + password + ", address=" + address + ", email=" + email + ", phone=" + phone
				+ "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
