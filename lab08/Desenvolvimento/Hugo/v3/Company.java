package lab08.v3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
	public static User user;
	private List<Employee> emps = new ArrayList<>();
	private List<Card> cards = new ArrayList<>();
	

	public void admitEmployee(Employee e) {
		emps.add(e);
	}
	
	public void createCard(Employee emp) {
		cards.add(new Card(emp));
	}

	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount();
			ba.deposit(e.getSalary());
		}
	}
	
	public double getAvg() {
		double sum = 0;
		int numEmp = 0;
		for (Employee emp : emps) {
			sum+=emp.getSalary();
			numEmp++;
		}
		if(numEmp>1) {
			return sum/numEmp;
		}
		return 0;
	}

	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}

	public List<Card> getCards() {
		return Collections.unmodifiableList(cards);
	}
}
