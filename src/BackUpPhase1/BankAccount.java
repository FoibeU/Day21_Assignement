package BackUpPhase1;

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
public String getAccountHolder() {
	return accountHolder;
}


public double getBalance() {
	return balance;
}



// Deposit money into the account
public double deposit(double amount) {
	if (amount <= 0) {
		System.out.println("Invalid deposit amount.");
		return balance;
	}
	
	balance += amount;
	return balance;
}

// Withdraw money only when enough money is available
public  boolean withdraw(double amount) {
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