package BackUpPhase2;

public class BankAccount {

private String accountName;
private String accountHolder;
private double balance;

public BankAccount(double balance) {
	this.balance = balance;
}

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

public synchronized double getBalance() {
	return balance;
}

public synchronized  double deposit(double amount) {
	if (amount <= 0) {
		System.out.println("Invalid deposit amount.");
		return balance;
	}
	balance += amount;
	return balance;
}

public synchronized  boolean withdraw(double amount) {
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
	return "BankAccount{" + "accountName='" + accountName + '\'' +  ", accountHolder='" + accountHolder + '\'' +", balance=" + getBalance() +'}';
}
}