package LAB7.v1;

import java.util.Date;

public class Employee implements EmployeeInterface{
	private Date sWork;
	private Date eWork;
	private String name;
	public Employee(String name) {
		this.name=name;
	}

	@Override
	public void start(Date d) {
		this.sWork=d;
	}

	@Override
	public void terminate(Date d) {
		this.eWork=d;
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("O " + name + " está trabalhando!");
	}

}
