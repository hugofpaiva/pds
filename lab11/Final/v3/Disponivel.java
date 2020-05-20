package lab11.Final.v3;

public class Disponivel implements State {

	public Disponivel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void regista(Livro l) {
		System.err.println("Operação não suportada");
	}

	@Override
	public void requisita(Livro l) {
		l.setState(new Emprestado());
	}

	@Override
	public void devolve(Livro l) {
		System.err.println("Operação não suportada");
	}

	@Override
	public void cancelaReserva(Livro l) {
		System.err.println("Operação não suportada");
	}

	@Override
	public void reserva(Livro l) {
		l.setState(new Reservado());
	}

	public String toString() {
		return "[Disponível]";
	}
}
