package LAB8.v1b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum User { OWNER, COMPANY }
public class Company {
	public static User user;
	private List<Employee> emps = new ArrayList<>();
	public void admitEmployee(Person p, double salary) { 
		Employee e = new Employee(p, salary); 
		emps.add(e);
	}
	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount(); 
			ba.deposit(e.getSalary());
		}
	}
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}
}
