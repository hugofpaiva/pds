package LAB6;

public class Colaborador {
	private String nome;
	private String apelido = null;
	private int codigo;
	private double salario;
	
	public Colaborador(String nome, String apelido, int codigo, double salario) {
		this.nome=nome;
		this.apelido=apelido;
		this.codigo=codigo;
		this.salario=salario;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getApelido() {
		return this.apelido;
	}
	
	public double getSalario() {
		return this.salario;
	}

}
