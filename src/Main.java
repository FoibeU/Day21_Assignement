import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

public static void main(String[] args) {
	try {
		List<BankAccount> bankAccountList = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			bankAccountList.add(new BankAccount(10000));
		}
		System.out.println("Created 10 bank accounts.");
		System.out.println("Initial total balance: $100000.00");
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Random random = new Random();
		long startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			int sourceAccount = random.nextInt(bankAccountList.size());
			int destinationAccount;
			do {
				destinationAccount = random.nextInt(bankAccountList.size());
			}
			while (destinationAccount == sourceAccount);
			BankAccount source = bankAccountList.get(sourceAccount);
			BankAccount destination = bankAccountList.get(destinationAccount);
			double amountToTransfer = 1 + random.nextInt(1000);
			TransferTask task = new TransferTask(source, destination, amountToTransfer);
			executorService.execute(task);
		}
		
		System.out.println("Submitted all 100,000 transfer tasks.");
		executorService.shutdown();
		try {
			boolean finished = executorService.awaitTermination(10, TimeUnit.MINUTES);
			if (!finished) {
				executorService.shutdownNow();
				System.out.println("Tasks did not finish in time.");
				return;
			}
			
		} catch (InterruptedException e) {
			executorService.shutdownNow();
			Thread.currentThread().interrupt();
			System.out.println("Waiting for tasks was interrupted.");
			return;
		}
		
		double totalBalance = 0;
		System.out.println("\n--- FINAL ACCOUNT BALANCES ---");
		for (int i = 0; i < bankAccountList.size(); i++) {
			BankAccount account = bankAccountList.get(i);
			System.out.printf("Account %d balance: $%.2f%n", i + 1, account.getBalance());
			totalBalance += account.getBalance();
		}
		long endTime = System.nanoTime();
		double executionTime = (endTime - startTime) / 1_000_000_000.0;
		
		System.out.printf("%nTotal balance: $%.2f%n", totalBalance);
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
}
}