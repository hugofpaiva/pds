package LAB8.v2;

import java.util.ArrayList;
import java.util.List;

public class SocialSecurity {
	List<Employee> registados = new ArrayList<>();
	
	public void regist(Employee e) {
		registados.add(e);
		System.out.println(e.getName()+" tem o salario descontado para a seguranca social!");
	}

}
