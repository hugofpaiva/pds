package LAB8.v2;

import java.util.ArrayList;
import java.util.List;

public class Parking{
	List<Employee> permitidos = new ArrayList<>();
	Company companhia;
	
	public Parking(Company c) {
		companhia=c;
	}
	
	public void allow(Employee e) {
		if(companhia.employees().size()>0 && e.getSalary()>companhia.getAverage()) {
			permitidos.add(e);
			System.out.println(e.getName()+" tem lugar de estacionamento!");
		}else {
			System.out.println("O employee "+ e.getName() +" não tem o salário acima da média");
		}
		//System.out.println(e.getName() + " - media: " + companhia.getAverage() + " salario: " + e.getSalary());
	}
}
