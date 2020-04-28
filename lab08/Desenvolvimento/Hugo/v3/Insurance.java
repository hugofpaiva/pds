package lab08.v3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Insurance {
	private String name;
	private List<Employee> registered = new ArrayList<>();
	
	public Insurance(String name) {
		this.name = name;
	}
	
	public void regist(Employee emp) {
		System.out.println("User registered in the insurance " + name);
		registered.add(emp);
	}
	
	public String getName() {
		return name;
	}
	
	public List<Employee> registered() {
		return Collections.unmodifiableList(registered);
	}

}
