import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Random value ranging from other than [0-4]
		int option = 5;
		int choice;
		double deposit;
		double widthdraw;
		double interest;
		int checkAccountCounter = 0;
		int saveAccountCounter = 0;
		String accountNumber;
		Account account;
		Bank bank = new Bank();
		CheckingAccount checkAccount = new CheckingAccount();
		SavingAccount saveAccount = new SavingAccount();

		Scanner obj = new Scanner(System.in);

		while (option != 0) {
			System.out.print("--------Bank System--------\n" + "1. Opening Account\n" + "2. Deposit\n" + "3. Withdraw\n"
					+ "4. Apply Interest\n" + "0. Exit\n" + "Choose an option: ");
			option = obj.nextInt();

			switch (option) {
			case 1:
				System.out.print("Choose account type (1: Checking, 2: Savings): ");
				choice = obj.nextInt();
				if (choice == 1) {
					account = new CheckingAccount();
					account.setAccountNumber("C00" + checkAccountCounter++); // need to improve here
					System.out.print("Enter initial balance: ");
					account.setBalance(obj.nextDouble());
					System.out.print("Enter overdraft limit: ");
					if (account instanceof CheckingAccount) {
						checkAccount = (CheckingAccount) account;
					}
					checkAccount.setOverdraftLimit(obj.nextDouble());
					bank.addAccount(checkAccount);
					System.out.print(bank.getAccount(checkAccount.getAccountNumber()) + "\n\n");
				} else {
					account = new SavingAccount();
					account.setAccountNumber("S00" + saveAccountCounter++);
					System.out.print("Enter initial balance: ");
					account.setBalance(obj.nextDouble());
					System.out.print("Enter interest rate(%): ");
					if (account instanceof SavingAccount) {
						saveAccount = (SavingAccount) account;
					}
					saveAccount.setInteresRate(obj.nextDouble());
					bank.addAccount(saveAccount);
					System.out.print(bank.getAccount(saveAccount.getAccountNumber()) + "\n\n");
				}
				break;
			case 2:
				System.out.print("\n--------Account Deposit--------\n");
				System.out.print("Enter account number: ");
				accountNumber = obj.next();
				System.out.print("Enter deposit amount: ");
				deposit = obj.nextDouble();
				bank.depositToAccount(accountNumber, deposit);

				System.out.printf(
						"\n--------Deposit Success--------\n" + "Account number: %s\n" + "Initial balance: %.1f\n"
								+ "Deposited: %.1f\n" + "New balance: %.1f\n\n",
						bank.getAccount(accountNumber).getAccountNumber(),
						(bank.getAccount(accountNumber).getBalance() - deposit), deposit,
						bank.getAccount(accountNumber).getBalance());
				break;
			case 3:
				System.out.print("\n-------Account Widthdraw--------\n");
				System.out.print("Enter account number: ");
				accountNumber = obj.next();
				if (Character.toString(bank.getAccount(accountNumber).getAccountNumber().charAt(0)).equals("C")) {
					System.out.print("Enter widthdrawal amount: ");
					widthdraw = obj.nextDouble();

					if (bank.getAccount(accountNumber) instanceof CheckingAccount) {
						checkAccount = (CheckingAccount) bank.getAccount(accountNumber);
					}
					
					

					if (widthdraw <= checkAccount.getBalance() || widthdraw - checkAccount.getBalance() <= checkAccount.getOverdraftLimit()) {
						bank.withdrawFromAccount(accountNumber, widthdraw);
						System.out.printf("\n--------Widthdrawal Success--------\n" + "Account number: %s\n"
								+ "Initial balance: %.1f\n" + "Widthdrawal amount: %.1f\n" + "New balance: %.1f\n\n",
								bank.getAccount(accountNumber).getAccountNumber(),
								(bank.getAccount(accountNumber).getBalance() + widthdraw), widthdraw,
								bank.getAccount(accountNumber).getBalance());
					} else {
						System.out.print("\n--------Widthdrawal Failed--------\n" + "Invalid widthdrawal amount\n\n");
					}
				} else {
					System.out.print("Enter widthdrawal amount: ");
					widthdraw = obj.nextDouble();
					System.out.print("\n--------Widthdrawal Failed--------\n"
							+ "Widthdrawal not allowed on Savings Account\n\n");
				}
				break;
			case 4:
				System.out.print("\n--------Apply Interest--------\n");
				System.out.print("Enter account number: ");
				accountNumber = obj.next();

				if (Character.toString(bank.getAccount(accountNumber).getAccountNumber().charAt(0)).equals("S")) {
					bank.getAccount(accountNumber).applyInterest();

					if (bank.getAccount(accountNumber) instanceof SavingAccount) {
						saveAccount = (SavingAccount) bank.getAccount(accountNumber);
					}

					interest = saveAccount.getBalance()
							- (saveAccount.getBalance() / (1 + saveAccount.getInteresRate()));

					System.out.printf(
							"Account number: %s\n" + "Initial balance: %.1f\n" + "Deposited: %.1f\n"
									+ "New balance: %.1f\n\n",
							saveAccount.getAccountNumber(), saveAccount.getBalance() - interest, interest,
							saveAccount.getBalance());

					System.out.println("--------Interest Applied--------");
					System.out.printf(
							"Account number: %s\n" + "Initial balance: %.1f\n" + "Interest Rate: %.1f%%\n"
									+ "New balance: %.1f\n\n",
							saveAccount.getAccountNumber(), saveAccount.getBalance() - interest,
							saveAccount.getInteresRate(), saveAccount.getBalance());
				} else {
					System.out.print("\n--------Interest Application Failed--------\n"
							+ "Interest not applied to Checking Account\n\n");
				}

				break;

			}
		}

	}

}
