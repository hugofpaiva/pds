package LAB8.v1b;

public class Employee{
	private Person p;
	private double salary;
	private BankAccount bankAccount;
	public Employee(Person p, double s) {
	    salary = s;
	    this.p=p;
	    bankAccount = new BankAccountProxy(new BankAccountImpl("PeDeMeia", 0)); 
	}
	public double getSalary() { 
		return salary;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	
}
