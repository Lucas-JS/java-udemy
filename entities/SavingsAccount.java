package entities;

// blocking inheritance by making a final class or method, this also can increase perfomance in some cases
public final class SavingsAccount extends Account{

	private Double interestRate;
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount( Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() {
		balance += balance * interestRate;
	}
	
	@Override
	public void withdraw(double value) {
		balance -= value;
	}
	
}
