package lab08.v3;

import java.util.List;

public class SharkCompany2 {

	public static void main(String[] args) {
		Facade companyFacade = new Facade();
		Company shark = companyFacade.getComp();
		Company.user = User.COMPANY;
		
		Person[] persons = { new Person("Maria Silva"), new Person("Manuel Pereira"), new Person("Aurora Machado"),
				new Person("Augusto Lima") };

		companyFacade.admitEmployee(persons[0], 1000);
		companyFacade.admitEmployee(persons[1], 900);
		companyFacade.admitEmployee(persons[2], 1200);
		companyFacade.admitEmployee(persons[3], 1100);
		
		List<Employee> sharkEmps = shark.employees();
		
		for (Employee e : sharkEmps)
			System.out.println(e.getSalary());
		shark.paySalaries(1);
	}
	

}
