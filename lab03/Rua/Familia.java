import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class Familia implements Comparable<Familia> {
	private ArrayList<Pessoa> membros = new ArrayList<Pessoa>();// LISTA DE MEMBROS PERTENCENTES À FAMÍLIA
	private int pos_in;											// POSIÇÃO INICIAL DOS TERRENOS
	private int pos_fin;										// POSIÇÃO FINAL DOS TERRENOS

	public Familia(Pessoa pes, int pos_in, int pos_fin) {
		membros.add(pes);
		this.pos_in = pos_in;
		this.pos_fin = pos_fin;
	}

	/* SIGNIFICADO DOS RETURNS:
		. 0 - PESSOA ADICIONADA COM SUCESSO
		. 1 - PESSOA NÃO FOI ADICIONADA PORQUE NÃO ESTÁ NO RANGE DESTA FAMÍLIA
		. 2 - PESSOA NÃO FOI ADICIONADA PORQUE O NOME JÁ EXISTE
	*/
	public int addMembro(Pessoa m, int pos_in, int pos_fin) {
		// VERIFICA SE O NOME JÁ EXISTE
		if (!searchIn(m)) {
			// VERIFICA SE AS POSIÇÕES ATRIBUIDAS A UMA PESSOA SÃO IGUAIS ÀS DA FAMÍLIA EM QUESTÃO
			if (checkPos(pos_in, pos_fin)) {
				membros.add(m);
				System.out.println("\n" + m.getName() + " added with sucess to the family " + this.pos_in + "-" + this.pos_fin);
				return 0;
			} else {
				return 1;
			}
		} else {
			System.err.println("Name already exists!");
			return 2;
		}

	}

	// DEVOLVE OS MEMBROS DA FAMÍLIA
	public ArrayList<Pessoa> getMembros() {
		return membros;
	}

	// DEVOLVE O NÚMERO DE MEMBROS DA FAMÍLIA
	public int countMembros() {
		return membros.size();
	}
	
	// DEVOLVE A POSIÇÃO INICIAL DOS TERRENOS
	public int getPos_in() {
		return pos_in;
	}

	// ATRIBUI UM (NOVO) VALOR À POSIÇÃO INICIAL DOS TERRENOS
	public void setPos_in(int pos_in) {
		this.pos_in = pos_in;
	}

	// DEVOLVE A POSIÇÃO FINAL DOS TERRENOS
	public int getPos_fin() {
		return pos_fin;
	}

	// ATRIBUI UM (NOVO) VALOR À POSIÇÃO FINAL DOS TERRENOS
	public void setPos_fin(int pos_fin) {
		this.pos_fin = pos_fin;
	}

	// ATRIBUI UM NOVO CONJUNTO À LISTA DE MEMBROS DA FAMÍLIA
	public void setMembros(ArrayList<Pessoa> membros) {
		this.membros = membros;
	}

	// DEVOLVE AS POSIÇÕES DOS TERRENOS DA FAMÍLIA
	public int[] getPosicoes() {
		return IntStream.rangeClosed(pos_in, pos_fin).toArray();
	}
	
	// DEVOLVE A QUANTIDADE DE TERRENOS DA FAMILIA
	public int getSizePosicoes() {
		return pos_fin-pos_in+1;

	}
	
	
	
	// FUNÇÃO QUE RETORNA true SE JÁ EXISTIR UMA PESSOA COM O MESMO NOME NA FAMÍLIA 
	public boolean searchIn(Pessoa p) {
		for (Pessoa x : membros) {
			if (x.getName().equals(p.getName())) {
				return true;
			}
		}
		return false;
	}

	// FUNÇÃO QUE VERIFICA SE A POSIÇÃO INICIAL E FINAL DE UMA DADA PESSOA COINCIDE COM A DESTA FAMÍLIA
	public boolean checkPos(int pos_in, int pos_fin) {
		if (this.pos_in == pos_in && this.pos_fin == pos_fin) {
			return true;
		} else {
			return false;
		}
	}
	
	// FUNÇÃO PARA ORDERNAR
	public int compareTo(Familia f) 
    { 
        return this.getSizePosicoes() - f.getSizePosicoes(); 
    } 

}
