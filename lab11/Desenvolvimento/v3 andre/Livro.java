package LAB11.v3;

public class Livro {
	String titulo, autor;
	int isbn, ano;
	State estado;
	public Livro(String titulo, String autor, int isbn, int ano) {
		this.ano=ano;
		this.autor=autor;
		this.isbn=isbn;
		this.titulo=titulo;
		this.estado=new Inventario();
	}
	
	public void setState(State s) {
		estado=s;
	}
	
	public void regista() {
		estado.regista(this);
	}
	
	public void requisita() {
		estado.requisita(this);
	}
	
	public void reserva() {
		estado.reserva(this);
	}
	
	public void cancelaReserva() {
		estado.cancelaReserva(this);
	}
	
	public void devolve() {
		estado.devolve(this);
	}

	public String titulo() {
		return this.titulo;
	}
	
	public String autor() {
		return this.autor;
	}
	
	public int ano() {
		return this.ano;
	}
	
	public int isbn() {
		return this.isbn;
	}
	
	public String estado() {
		return this.estado.toString();
	}
	
}
