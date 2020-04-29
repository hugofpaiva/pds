enum User {OWNER, COMPANY}
public class BankAccProxy implements BankAccount{
	private BankAccount bank;
	
	BankAccProxy (BankAccount bank) {
		this.bank = bank;
	}
	
	public void deposit(double amount) {
		bank.deposit(amount);
		
	}
	
	@Override public boolean withdraw(double amount) {
		if(Company.user == User.OWNER) {
			return bank.withdraw(amount);
		} else {
			System.out.println(Company.user);
			System.out.println("Operation denied!");
			return false;
		}
	}
	
	@Override public double balance() {
		if(Company.user == User.OWNER) {
			return bank.balance();
		} else {
			System.out.println("Operation denied!");
			return Double.NaN;
		}
	}
	
	
	

}
