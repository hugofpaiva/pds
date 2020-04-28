package LAB8.v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum User { OWNER, COMPANY }
public class Company {
	public static User user;
	private List<Employee> emps = new ArrayList<>();
	private List<EmployeeCard> cards = new ArrayList<>();
	
	public void admitEmployee(Employee e) {
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
	public Double getAverage() {
		Double avg=(double) 0;
		
		if(emps.size() <= 1) {
			return avg;
		}
		
		for(Employee e:emps) {
			avg+=e.getSalary();
		}
		return avg/emps.size();
	}
	public void addCard(Employee e) {
		EmployeeCard ec=new EmployeeCard(e);
		cards.add(ec);
	}
}
