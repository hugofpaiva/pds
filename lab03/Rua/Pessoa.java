
public class Pessoa{
	private String nome;
	
	public Pessoa(String nome) {
		if(checkName(nome)) {
			this.nome=nome;
		}
	}
	
	public boolean checkName(String nome) {
		// VERIFICA SE O NOME DA PESSOA TEM TAMANHO COMPREENDIDO ENTRE [3, 30]
		if(nome.length() < 3 || nome.length() > 30) {
			System.out.println("O nome não pode exceder os limites 3 e 30.");
			return false;
		}

		// VERIFICA SE O ULTIMO CARACTER É UMA LETRA/NUMERO
		String ultimoChar = String.valueOf(nome.charAt(nome.length()-1));
		if(ultimoChar.matches("[^A-Za-z0-9]")){
			System.out.println("O ultimo caractern não pode ser um símbolo");
			return false;
		}
		
		// VERIFICA SE O PRIMEIRO CARACTER É UMA LETRA
		String primeiroChar = String.valueOf(nome.charAt(0));
		if(primeiroChar.matches("[^A-Za-z]")){
			System.out.println("O primeiro caracter tem de ser uma letra");
			return false;
		}
		
		// VERIFICA SE O NOME É COMPOSTO APENAS POR LETRAS (MAIUSCULAS/MINUSCULAS), NUMEROS, PONTOS, UNDERSCORE OU ARROBAS
		if(!nome.matches("[A-Za-z0-9._@]+")){
			System.out.println("O nome apenas permite caracteres alfanuméricos, pontos, underscores e arrobas.");
			return false;
		}
		
		return true;
	}
	
	// DEVOLDE O NOME DA PESSOA
	public String getName() {
		return this.nome;
	}
}


