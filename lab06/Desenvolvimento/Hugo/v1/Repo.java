package lab06;

import java.util.ArrayList;
import java.util.List;

public class Repo {
	// Data elements
	private ArrayList<Colaborador> guys; // Stores the employees

	public Repo() {
		guys = new ArrayList<>();
	}

	public void insere(Colaborador col) {
		guys.add(col);
	}

	public void remove(int codigo) {
		for (int i = 0; i < guys.size(); i++) {
			if (guys.get(i).codigo() == codigo) {
				guys.remove(guys.get(i));
			}
		}
	}

	public boolean isColaborador(int codigo) {
		for (int i = 0; i < guys.size(); i++) {
			if (guys.get(i).codigo() == codigo) {
				return true;
			}
		}
		return false;
	}

	public List<Colaborador> listaDeEmpregados() {
		return guys;
	}
}