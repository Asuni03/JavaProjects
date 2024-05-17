import java.util.HashMap;
import java.util.Map;

public class Bank {
	private Map<String, Account> accounts = new HashMap<>();

	// Default constructor
	public Bank() {

	}

	public Bank(Map<String, Account> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(Account account) {
		accounts.put(account.getAccountNumber(), account);
	}

	public Account getAccount(String accountNumber) {
		return accounts.get(accountNumber);
	}

	public void depositToAccount(String accountNumber, double deposit) {
		this.getAccount(accountNumber).deposit(deposit);
	}

	public void withdrawFromAccount(String accountNumber, double widthdraw) {
		this.getAccount(accountNumber).withdraw(widthdraw);
	}

	public void applyInterestToAccount(String accountNumber) {
		this.getAccount(accountNumber).applyInterest();
	}

}
