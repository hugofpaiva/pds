package LAB3.Rua;

import java.util.ArrayList;
import java.util.Arrays;

public class Familia {
	private ArrayList<Pessoa> membros;
	private ArrayList<Integer> posicoes;
	public Familia(Pessoa pes, Integer[] pos){
		membros.add(pes);
		posicoes.addAll(Arrays.asList(pos));
	}
	
	public void addMembro(Pessoa m) {
		this.membros.add(m);
	}
	
	public ArrayList<Pessoa> getMembros() {
		return this.membros;
	}
	
	public ArrayList<Integer> getPosicoes() {
		return this.posicoes;
	}
	
	public boolean searchIn(Pessoa p) {
		for(Pessoa x : membros) {
			if(x.getName().equals(p.getName())) {
				return false;
			}
		}
		return true;
	}
	
	
}
