package com.revature.bean;

import java.io.Serializable;

public class AccountInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6663025529942214694L;
	private int deposit;
	private int withdraw;
	private int balance;
	private int previousTransaction;
	public AccountInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		result = prime * result + deposit;
		result = prime * result + previousTransaction;
		result = prime * result + withdraw;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountInfo other = (AccountInfo) obj;
		if (balance != other.balance)
			return false;
		if (deposit != other.deposit)
			return false;
		if (previousTransaction != other.previousTransaction)
			return false;
		if (withdraw != other.withdraw)
			return false;
		return true;
	}
	public AccountInfo(int deposit, int withdraw, int balance, int previousTransaction) {
		super();
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.balance = balance;
		this.previousTransaction = previousTransaction;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public int getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getPreviousTransaction() {
		return previousTransaction;
	}
	public void setPreviousTransaction(int previousTransaction) {
		this.previousTransaction = previousTransaction;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "AccountInfo [deposit=" + deposit + ", withdraw=" + withdraw + ", balance=" + balance
				+ ", previousTransaction=" + previousTransaction + "]";
	}
	
	
	

}
