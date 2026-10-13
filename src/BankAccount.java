public class BankAccount {

private String accountName;
private String accountHolder;
private double balance;

// Constructor for creating an account with an initial balance
public BankAccount(double balance) {
	this.balance = balance;
}

// Constructor for creating an account with account details
public BankAccount(String accountName, String accountHolder, double balance) {
	this.accountName = accountName;
	this.accountHolder = accountHolder;
	this.balance = balance;
}

public String getAccountName() {
	return accountName;
}

public void setAccountName(String accountName) {
	this.accountName = accountName;
}

public String getAccountHolder() {
	return accountHolder;
}

public void setAccountHolder(String accountHolder) {
	this.accountHolder = accountHolder;
}

public synchronized double getBalance() {
	return balance;
}

public synchronized void setBalance(double balance) {
	if (balance < 0) {
		throw new IllegalArgumentException("Balance cannot be negative.");
	}
	this.balance = balance;
}

// Deposit money into the account
public synchronized double deposit(double amount) {
	if (amount <= 0) {
		System.out.println("Invalid deposit amount.");
		return balance;
	}
	
	balance += amount;
	return balance;
}

// Withdraw money only when enough money is available
public synchronized boolean withdraw(double amount) {
	if (amount <= 0) {
		System.out.println("Invalid withdrawal amount.");
		return false;
	}
	
	if (balance < amount) {
		return false;
	}
	
	balance -= amount;
	return true;
}

@Override
public String toString() {
	return "BankAccount{" +
			       "accountName='" + accountName + '\'' +
			       ", accountHolder='" + accountHolder + '\'' +
			       ", balance=" + getBalance() +
			       '}';
}
}