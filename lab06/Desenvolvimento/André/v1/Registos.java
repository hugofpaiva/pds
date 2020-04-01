package LAB6;

import java.util.ArrayList;
import java.util.List;

class Registos {
	// Data elements
	private ArrayList<Empregado> empregados; // Stores the employees 
	
	public Registos() {
		empregados=new ArrayList<>();
	}

	public void insere(Empregado emp) {
		empregados.add(emp);
	}

	public void remove(int codigo) {
		for(int i=0; i<empregados.size(); i++) {
			if(empregados.get(i).codigo()==codigo) {
				empregados.remove(empregados.get(i));
			}
		}
	}

	public boolean isEmpregado(int codigo) {
		for(int i=0; i<empregados.size(); i++) {
			if(empregados.get(i).codigo()==codigo) {
				return true;
			}
		}
		return false;
	}

	public List<Empregado> listaDeEmpregados() {
		return empregados;
	}
}
