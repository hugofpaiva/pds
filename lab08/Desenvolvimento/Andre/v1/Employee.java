package LAB8.v1;

public class Employee extends Person{
	private double salary;
	public Employee(String n, double s) { 
		super(n);
	    salary = s; 
	}
	public double getSalary() { 
		return salary;
	}
}
