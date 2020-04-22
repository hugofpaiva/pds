public class CoderFilter extends FileDecorator{

	public CoderFilter(FileInterface file) {
		super(file);
	}

	/*
		*
		* CONVERTE O TEXTO NUMA CIFRA EM QUE A PRIMEIRA LETRA DO TEXTO É A LETRA IMEDIATAMENTE A SEGUIR NO CÓDIGO ASCII
		* E AS RESTANTES PODEM ADOTAR A SUA POSIÇÃO NÚMERICA, SE FOREM VOGAIS, OU PERMANECER INALTERADAS, SE FOREM CONSOANTES
		*
	 */

	public String next() {
		// Texto Cifrado
		String w = super.next();
		String cifra="";
		cifra+=(char)((int) w.charAt(0) + 1); 
		for(int i=1; i<w.length(); i++) {
			String c=String.valueOf(w.charAt(i)).toLowerCase();
			
			switch(c) {
				case "a": cifra+=1; break;
				case "e": cifra+=2; break;
				case "i": cifra+=3; break;
				case "o": cifra+=4; break;
				case "u": cifra+=5; break;
				default: cifra+=w.charAt(i);
			}
		}
		return cifra;
	}

}
