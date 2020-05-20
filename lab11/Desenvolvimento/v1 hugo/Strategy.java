package lab11.v1;

import java.util.ArrayList;
import java.util.List;

public interface Strategy {
	List<Phone> order(List<Phone> l);
}

class Algoritm implements Strategy {
	@Override
	public List<Phone> order(List<Phone> l) {
		System.out.println("Estou no Algoritmo!");
		return l;

	}
}

class Algoritm2 implements Strategy {
	@Override
	public List<Phone> order(List<Phone> l) {
		System.out.println("Estou no Algoritmo2!");
		return l;

	}
}

class Algoritm3 implements Strategy {
	@Override
	public List<Phone> order(List<Phone> l) {
		System.out.println("Estou no Algoritmo3!");
		return l;
		
	}
}
