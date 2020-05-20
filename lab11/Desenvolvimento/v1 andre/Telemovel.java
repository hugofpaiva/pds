package LAB11.v1;

public class Telemovel {
	String nome;
	String processador;
	Double preco;
	int memoria; // em MB
	String camara;
	public Telemovel(String nome, String processador, Double preco, int memoria, String camara) {
		this.nome=nome;
		this.processador=processador;
		this.preco=preco;
		this.memoria=memoria;
		this.camara=camara;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getProcessador() {
		return processador;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public int getMemoria() {
		return memoria;
	}
	
	public String getCamara() {
		return camara;
	}
	
	@Override
	public String toString() {
		return nome+" [processador=" + processador + ", preco=" + preco + ", memoria=" + (int) memoria/1000 + "GB, camara="
				+ camara + "]";
	}
	

}
