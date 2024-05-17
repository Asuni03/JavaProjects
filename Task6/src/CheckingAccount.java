
public class CheckingAccount extends Account {
	private double overdraftLimit;

	// Default constructor
	public CheckingAccount() {

	}

	// Constructor overriding
	public CheckingAccount(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	public void withdraw(double amount) {
		this.setBalance(this.getBalance() - amount);
	}

	@Override
	public void applyInterest() {

	}

	@Override
	public String toString() {
		String info = "\n--------Account Opened--------\n" + "Account number: " + super.getAccountNumber() + "\n"
				+ "Account type: Checking\n" + "Initial balance: " + super.getBalance() + "\n" + "Overdraft limit: "
				+ this.getOverdraftLimit();
		return info;
	}

}
