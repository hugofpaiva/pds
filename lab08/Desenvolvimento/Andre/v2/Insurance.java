package LAB8.v2;

import java.util.ArrayList;
import java.util.List;

public class Insurance {
	List<Employee> registados = new ArrayList<>();
	
	public void regist(Employee e) {
		registados.add(e);
		System.out.println(e.getName()+" tem seguro!");
	}
}
