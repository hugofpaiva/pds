package lab11.Final.v1;

import java.util.Arrays;
import java.util.Comparator;

public class Revista {
	SortInterface alg;
	Telemovel[] catalogo;
	
	public Revista(Telemovel[] t) {
		this.catalogo=t;
	}

	
	public void setSortAlgorithm(SortInterface alg) {
		this.alg=alg;
	}
	
	public void sort() {
		alg.sort();
	}
	
	public Telemovel[] getCatalogo() {
		return catalogo;
	}
	
	public void read() {
		for(Telemovel t : catalogo) {
        	System.out.println(t);
        } 
	}
}
