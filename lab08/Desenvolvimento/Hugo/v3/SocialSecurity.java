package lab08.v3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SocialSecurity {
	private List<Employee> registered = new ArrayList<>();
	
	public void regist(Employee emp) {
		System.out.println("User registered in the Social Security");
		registered.add(emp);
	}
	
	public List<Employee> registered() {
		return Collections.unmodifiableList(registered);
	}

}
