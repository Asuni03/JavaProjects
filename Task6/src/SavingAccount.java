
public class SavingAccount extends Account {
	private double interesRate;

	// Default constructor
	public SavingAccount() {

	}

	// Constructor overriding
	public SavingAccount(double interesRate) {
		this.interesRate = interesRate;
	}

	public double getInteresRate() {
		return interesRate;
	}

	public void setInteresRate(double interesRate) {
		this.interesRate = interesRate;
	}

	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
	}

	@Override
	public void applyInterest() {
		this.setBalance(this.getBalance() + (this.getBalance() * this.interesRate) / 100);
	}

	@Override
	public String toString() {
		String info = "\n--------Account Opened--------\n" + "Account number: " + super.getAccountNumber() + "\n"
				+ "Account type: Savings\n" + "Initial balance: " + super.getBalance() + "\n" + "Interest rate(%): "
				+ this.getInteresRate();
		return info;
	}

}
