import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parking {
	private String name;
	private Company comp;
	private List<Employee> allowed = new ArrayList<>();
	
	public Parking(String name, Company comp) {
		this.name = name;
		this.comp = comp;
		
	}
	
	public boolean allow(Employee emp) {
		if(emp.getSalary()>comp.getAvg()) {
			allowed.add(emp);
			System.out.println("Employee " + emp.getName() + " allowed in the park.");
			return true;	
		}
		System.err.println("Employee " + emp.getName()+" with less salary than average not allowed in the park.");
		return false;

	}
		
	public String getName() {
		return name;
	}


	public List<Employee> allowed() {
		return Collections.unmodifiableList(allowed);
	}

}
