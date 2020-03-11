
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Familia {
	private ArrayList<Pessoa> membros = new ArrayList<Pessoa>();
	private int pos_in;
	private int pos_fin;

	public Familia(Pessoa pes, int pos_in, int pos_fin) {
		membros.add(pes);
		this.pos_in = pos_in;
		this.pos_fin = pos_fin;
	}
	/* Explicação dos returns:
	
	0 - Pessoa Adicionada com Sucesso
	1 - Pessoa não foi adicionada pq não está no range desta familia
	2 - Pessoa não foi adicionada pq o nome já existe
	
	*/
	public int addMembro(Pessoa m, int pos_in, int pos_fin) {
		if (!searchIn(m)) {
			if (checkPos(pos_in, pos_fin)) {
				membros.add(m);
				System.out.println("\n" + m.getName() + " adicionado(a) com sucesso à familia " + this.pos_in + "-" + this.pos_fin);
				return 0;
			} else {
				return 1;
			}

		} else {
			System.err.println("Nome já existe!");
			return 2;
		}

	}

	public ArrayList<Pessoa> getMembros() {
		return membros;
	}
	
	public int getPos_in() {
		return pos_in;
	}
	public void setPos_in(int pos_in) {
		this.pos_in = pos_in;
	}
	public int getPos_fin() {
		return pos_fin;
	}
	public void setPos_fin(int pos_fin) {
		this.pos_fin = pos_fin;
	}
	public void setMembros(ArrayList<Pessoa> membros) {
		this.membros = membros;
	}
	public int[] getPosicoes() {
		return IntStream.rangeClosed(pos_in, pos_fin).toArray();

	}
	
	public boolean searchIn(Pessoa p) {
		for (Pessoa x : membros) {
			if (x.getName().equals(p.getName())) {
				return true;
			}
		}
		return false;
	}

	public boolean checkPos(int pos_in, int pos_fin) {
		if (this.pos_in == pos_in && this.pos_fin == pos_fin) {
			return true;
		} else {
			return false;
		}
	}

}
