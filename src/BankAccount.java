public class BankAccount {
private String accountName;
private String accountHolder;
private  Double balance;


public BankAccount(String accountName, String accountHolder, Double balance) {
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

public Double getBalance() {
	return balance;
}

public void setBalance(Double balance) {
	this.balance = balance;
}
public Double deposit(double amount){
	if(amount <= 0){
		System.out.println("Invalid balance");
	}else{
		balance+=amount;
	}
	
	return balance+amount;
	
}
public Double withdraw(Double amount){
	if (amount > balance||balance <= 0){
		System.out.println("You have Insuffient balance");
	}else{
	balance-=amount;
	}return balance - amount;
}

}
