package lab11.v1;

import java.util.ArrayList;
import java.util.List;

public class Revista {
	private Strategy opStrategy;
	private ArrayList<Phone> phones;

	public void add(Phone p) {
		phones.add(p);
	}

	public void remove(Phone p) {
		phones.remove(p);
	}

	public List<Phone> order() {
		if (opStrategy != null && phones.size() > 0) {
			return opStrategy.order(phones);
		}

		System.err.println("Nenhum algoritmo definido ou nenhum telemóvel!");
		System.exit(0);
		return null;


	}

	public void setStrategy(Strategy strategy) {
		opStrategy = strategy;
	}
}
