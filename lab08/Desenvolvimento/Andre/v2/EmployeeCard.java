package LAB8.v2;

public class EmployeeCard {
	Employee e;
	public EmployeeCard(Employee e) {
		this.e=e;
	}
	public String getName() {
		return e.getName();
	}
}
