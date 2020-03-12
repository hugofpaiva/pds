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
			System.out.println("The name cannot exceed limits 3 and 30.");
			return false;
		}

		// VERIFICA SE O ULTIMO CARACTER É UMA LETRA/NUMERO
		String ultimoChar = String.valueOf(nome.charAt(nome.length()-1));
		if(ultimoChar.matches("[^A-Za-z0-9]")){
			System.out.println("The last character cannot be a symbol.");
			return false;
		}
		
		// VERIFICA SE O PRIMEIRO CARACTER É UMA LETRA
		String primeiroChar = String.valueOf(nome.charAt(0));
		if(primeiroChar.matches("[^A-Za-z]")){
			System.out.println("The first character must be a letter.");
			return false;
		}
		
		// VERIFICA SE O NOME É COMPOSTO APENAS POR LETRAS (MAIUSCULAS/MINUSCULAS), NUMEROS, PONTOS, UNDERSCORE OU ARROBAS
		if(!nome.matches("[A-Za-z0-9._@]+")){
			System.out.println("The name only allows alphanumeric characters, periods, underscores and arrobes.");
			return false;
		}
		
		return true;
	}
	
	// DEVOLDE O NOME DA PESSOA
	public String getName() {
		return this.nome;
	}
}


