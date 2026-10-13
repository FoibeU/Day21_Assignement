package BackUpPhase1;

public class TransferTask implements Runnable {

private BankAccount sourceAccount;
private BankAccount destinationAccount;
private double amountToTransfer;

public TransferTask(
		BankAccount sourceAccount,
		BankAccount destinationAccount,
		double amountToTransfer) {
	
	this.sourceAccount = sourceAccount;
	this.destinationAccount = destinationAccount;
	this.amountToTransfer = amountToTransfer;
}

@Override
public void run() {
	
	// Check that both accounts exist
	if (sourceAccount == null || destinationAccount == null) {
		System.out.println("Error: Source or destination account is null.");
		return;
	}
	
	// Do not transfer money to the same account
	if (sourceAccount == destinationAccount) {
		return;
	}
	
	// Withdraw first, then deposit only if successful
	boolean successful = sourceAccount.withdraw(amountToTransfer);
	
	if (successful) {
		destinationAccount.deposit(amountToTransfer);
	}
}
}