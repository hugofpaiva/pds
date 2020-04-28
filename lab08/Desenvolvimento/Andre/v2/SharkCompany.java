package LAB8.v2;

import java.util.List;

public class SharkCompany {
	public static void main(String[] args) {
		Person[] persons = { new Person("Maria Silva"), new Person("Manuel Pereira"), new Person("Aurora Machado"), new Person("Augusto Lima") };
		CompanyFacade facade = new CompanyFacade();
		Company.user = User.COMPANY;
		facade.admitEmployee(persons[0], 1000);
		facade.admitEmployee(persons[1], 900);
		facade.admitEmployee(persons[2], 1200);
		facade.admitEmployee(persons[3], 1100);
		List<Employee> sharkEmps = facade.Companhia().employees();
		for (Employee e : sharkEmps)
			System.out.println(e.getSalary()); 
		facade.Companhia().paySalaries(1);
	}
}
