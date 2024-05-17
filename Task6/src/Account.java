
public abstract class Account implements AccountInterface {
	private String accountNumber;
	private double balance;

	public Account() {

	}

	// Constructor overriding
	public Account(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public Account(double balance) {
		this.balance = balance;
	}

	// Getters
	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	// Setters
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public void deposit(double amount) {
		this.setBalance(this.getBalance() + amount);
	}

}
