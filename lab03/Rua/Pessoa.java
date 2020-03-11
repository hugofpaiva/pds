package LAB3.Rua;

public class Pessoa{
	private String nome;
	
	public Pessoa(String nome) {
		if(checkName(nome)) {
			this.nome=nome;
		}
	}
	
	public boolean checkName(String nome) {
		if(nome.length() < 3 || nome.length() > 30) {
			System.out.println("O nome não pode exceder os limites 3 e 30.");
			return false;
		}
		
		String ultimoChar = String.valueOf(nome.charAt(nome.length()-1));
		if(!ultimoChar.matches("[^A-Za-z0-9]")){
			System.out.println("O ultimo caracter tem não pode ser um símbolo");
			return false;
		}
		
		String primeiroChar = String.valueOf(nome.charAt(0));
		if(!primeiroChar.matches("[^A-Za-z]")){
			System.out.println("O primeiro caracter tem de ser uma letra");
			return false;
		}
		
		if(nome.matches("[A-Za-z0-9._@]+")){
			System.out.println("O nome apenas permite caracteres alfanuméricos, pontos, underscores e arrobas.");
			return false;
		}
		
		return true;
	}
}


