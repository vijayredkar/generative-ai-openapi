package com.banknext.txn;

public class Entity {	
	
	private CustomerDTO customer;
	private Account account;
	
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "Entity [customer=" + customer + ", account=" + account + "]";
	}
	
	
		
}
