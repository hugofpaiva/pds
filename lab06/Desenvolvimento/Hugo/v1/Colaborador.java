package lab06;

public class Colaborador {
	private String nome;
    private String apelido;
    private int codigo;
    private double salario;
    String nomedomeio;

    public Colaborador(String nome, String nomedomeio, String apelido, int codigo, double salario) {
        this.nome = nome;
        this.apelido = apelido;
        this.apelido = apelido;
        this.nomedomeio = nomedomeio;
        this.codigo = codigo;
        this.salario = salario;
    }

    public String apelido() {
        return apelido;
    }

    public String nome() {
        return nome;
    }
    
    public String nomedomeio() {
        return nomedomeio;
    }

    public int codigo() {
        return codigo;
    }

    public double salario() {
        return salario;
    }
}
