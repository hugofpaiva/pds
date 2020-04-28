package lab08.v1;

public interface BankAccount {
	void deposit(double amount);

	boolean withdraw(double amount);

	double balance();

}
