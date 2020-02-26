import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WSGenerator {
	static List<String> palavras=new ArrayList<String>(); //LISTA DE PALAVRAS A SEREM ENCONTRADAS
	static int size=12; //DIMENCOES DA MATRIZ (O PADRÃO É 12 PARA O CASO DE O UTILIZADOR OPTAR POR NÃO ESCOLHER UM NUMERO DE LINHAS/COLUNAS)
	static char m[][] = new char[50][50]; //MATRIZ DA SOPA DE LETRAS
	static String saveFile; //NOME DO FICHEIRO QUE VAI SER GUARDADO
	static String stringPalavras=""; //VARIAVEL QUE GUARDA A ESTRUTURA INICIAL DAS PALAVRAS

	public static void main(String[] args) {
		String filename=""; 
		
		/*
			*
			*
			* PROCESSAMENTO DAS OPÇÕES
			*
			*
		*/
		for(int i=0; i<args.length; i++) {
			switch(args[i]) {
				case "-i": //OPÇAO DE ESCOLHA DO FICHEIRO QUE CONTÉM AS PALAVRAS
					filename=args[i+1];
					break;
				case "-s": //OPÇÃO DE ESCOLHA DO TAMANHO DA SOPA DE LETRAS
					size=Integer.valueOf(args[i+1]);
					if(size>50){
						System.out.println("A tabela não pode ser maior do que 50x50");
						System.exit(0);
					}
					break;
				case "-o": //OPÇÃO DE ESCOLHA DO NOME DO FICHEIRO QUE GUARDA A SOPA DE LETRAS
					saveFile=args[i+1];
					break;
				default: break;
			}
		}
		/*
			*
			*
			* LEITURA DO FICHEIRO
			*
			*
		*/
		try {
			File file = new File(filename); 
		    Scanner sc = new Scanner(file); 
		  
		    while (sc.hasNextLine()){
		    	String linha=sc.nextLine().trim().toUpperCase();
		    	stringPalavras+=linha+"\n";

		    	if(linha.contains(",") || linha.contains(";") || linha.contains(" ")) {
		    		String[] lista = linha.split("[,; ]");
		    		for(String s : lista){
						if(s.length() >= 4){ //APENAS ACEITA PALAVRAS COM MAIS DO QUE 3 CARACTERES
							palavras.add(s);
						}
						if(s.length() > size){ //AS PALAVRAS NÃO PODEM SER MAIORES DO QUE A MATRIZ
							System.out.println("A palavra não pode ser maior do que a sopa de letras!");
							System.exit(0);
						}
					}
					
		    	}else {
					if(linha.length() >= 4){ //APENAS ACEITA PALAVRAS COM MAIS DO QUE 3 CARACTERES
						palavras.add(linha);
					}
					if(linha.length() > size){ //AS PALAVRAS NÃO PODEM SER MAIORES DO QUE A MATRIZ
						System.out.println("A palavra não pode ser maior do que a sopa de letras!");
						System.exit(0);
					}
		    	}
		  	}
		    sc.close();
		}catch (IOException e) {
			System.out.println("O ficheiro não existe!");
			System.exit(0);
		}

		/*
			*
			*
			* VERIFICAÇÃO DE PALAVRAS REPETIDAS OU REDUNDANTES
			*
			*
		*/
		for (String palavra : palavras) {
			for (String palavra2 : palavras) {
				if (palavra.contains(palavra2) && !palavra.equals(palavra2)) { //VERIFICA SE AS DUAS PALAVRAS SÃO DIFERENTES MAS TÊM ALGO EM COMUM
					System.err.println("A lista de palavras contém palavras duplicadas ou frases redundantes!");
					System.exit(0);
				}
			}
		}
		
		/*
			*
			*
			* POSICIONAMENTO DAS PALAVRAS NA MATRIZ
			* TEM EM CONTA:
			* 	.ESCOLHA ALEATÓRIA DO SENTIDO QUE A PALAVRA VAI ADOTAR
			*	.ESCOLHA ALEATÓRIA DE UMA POSIÇÃO INICIAL COM BASE NAS POSIÇÕES EM QUE PODE COMEÇAR
			* NÚMERO ALEATÓRIO CORRESPONDENTE AO SENTIDO ADOTADO:
			*	.DIREITA-ESQUERDA 			(1)
			*	.ESQUERDA-DIREITA 			(2)
			*	.BAIXO-CIMA					(3)
			*	.CIMA-BAIXO					(4)
			*	.DIAGONAL CIMA ESQUERDA		(5)
			*	.DIAGONAL BAIXO ESQUERDA 	(6)
			*	.DIAGONAL BAIXO DIREITA		(7)
			*	.DIAGONAL CIMA DIREITA		(8)
			*
			*
		*/
		boolean wrote = false; //VARIAVEL QUE INDICA SE A PALAVRA PODE SER ESCRITA OU NÃO
		double startTime = System.currentTimeMillis(); //HORA DE COMEÇO DA CRIAÇÃO DA MATRIZ
		for(String word : palavras) {
			while(!wrote){
				if(((System.currentTimeMillis() - startTime) / 1000 )>1){ //VERIFICA SE JÁ FORAM FEITAS DEMASIADAS TENTATIVAS (MAIS DE 1 SEGUNDO)
					System.out.println("Não existe espaço para mais palavras. Ficou tudo ocupado ao tentar colocar:"+word);
					System.exit(0);
				}
				double randomInteger = Math.random();  //
				randomInteger = randomInteger * 8 + 1; // ESCOLHA ALEATÓRIA DE UM SENTIDO (CIMA, BAIXO, ESQUERDA, DIREITA, DIAGONAIS) 
				int randomInt = (int) randomInteger;   //

				switch(randomInt) {
					case 1: //SENTIDO: ESQUERDA
						//escolher uma linha aleatoria
						double randomNumber=Math.random();				//
						int randomLinha= (int) (randomNumber*(size));	//A PALAVRA PODE SER COLOCADA EM QUALQUER LINHA
						
						//escolher a coluna em que começa
						randomNumber=Math.random();														//
						int randomColuna= (int) ((randomNumber*(size-word.length()))+word.length());	//A PALAVRA TEM DE COMEÇAR NUMA POSIÇÃO ENTRE <TAMANHO DA PALAVRA> E <NUMERO DE COLUNAS> PARA PODER SER ESCRITA DA DIREITA PARA A ESQUERDA
						
						if(randomColuna>=size) {
							break;
						}
						
						boolean overwritten = false;									// 
						for(int i=randomColuna; i>randomColuna-word.length(); i--) {	//	
							if(m[randomLinha][i] != 0){									// EXCERTO DE CÓDIGO PRESENTE EM TODOS OS SENTIDOS, VERIFICA SE ALGUMA OUTRA PALAVRA JÁ FOI ESCRITA NAQUELE LUGAR
								overwritten=true;										//
							}															//
						}																//
						
						if(!overwritten) {
							int pos=0;
							for(int i=randomColuna; i>randomColuna-word.length(); i--) {	//
								m[randomLinha][i]=word.charAt(pos);							// EXCERTO DE CÓDIGO PRESENTE EM TODOS OS SENTIDOS, PREENCHE A TABELA SE NENHUMA OUTRA PALAVRA ESTIVER A OCUPAR AS POSIÇÕES DA MATRIZ PRETENDIDAS
								pos++;														//
							}
							wrote=true;
						}
						
						break;
					case 2: //SENTIDO: DIREITA
						//escolher uma linha aleatoria
						randomNumber=Math.random();					//
						randomLinha= (int) (randomNumber*(size));	//A PALAVRA PODE SER COLOCADA EM QUALQUER LINHA
						
						//escolher a coluna em que começa
						randomNumber=Math.random();										//
						randomColuna= (int) (randomNumber*(size-(word.length()-1))); 	//MAS HÁ RESTRIÇÕES A NIVEL DAS COLUNAS, A PALAVRA TEM DE COMECAR ENTRE 0 E <SIZE-TAMANHO_DA_PALAVRA>
						
						if(randomColuna<0) {
							break;
						}
						
						overwritten = false;
						for(int i=randomColuna; i<randomColuna+word.length(); i++) {
							if(m[randomLinha][i] != 0){
								overwritten=true;
							}
						}
						
						if(!overwritten) {
							int pos=0;
							for(int i=randomColuna; i<randomColuna+word.length(); i++) {
								m[randomLinha][i]=word.charAt(pos);
								pos++;
							}
							wrote=true;
						}
						break;
					case 3: //SENTIDO: CIMA
						//escolher uma coluna aleatoria
						randomNumber=Math.random();
						randomColuna= (int) (randomNumber*(size));	//NÃO EXISTEM RESTRIÇÕES AO NÍVEL DA COLUNA ESCOLHIDA
						
						//escolher uma linha onde pode começar
						randomNumber=Math.random();
						randomLinha= (int) (randomNumber*(size-word.length()) + word.length()); //MAS EXISTEM RESTRIÇÕES QUANTO À LINHA PORQUE A PALAVRA TEM DE COMEÇAR NUMA POSIÇÃO ENTRE <TAMANHO DA PALAVRA> E <TAMANHO DA MATRIZ> PARA QUE A PALAVRA SEJA ESCRITA DE BAIXO PARA CIMA
						
						if(randomLinha<0) {
							break;
						}
						
						overwritten = false;
						for(int i=randomLinha; i>randomLinha-word.length(); i--) {
							if(m[i][randomColuna] != 0){
								overwritten=true;
							}
						}
						
						if(!overwritten) {
							int pos=0;
							for(int i=randomLinha; i>randomLinha-word.length(); i--) {
								m[i][randomColuna]=word.charAt(pos);
								pos++;
							}
							wrote=true;
						}
						
						break;
					case 4: //SENTIDO: BAIXO
						//escolher uma coluna aleatoria
						randomNumber=Math.random();
						randomColuna= (int) (randomNumber*(size)); //NÃO EXISTEM RESTRIÇÕES AO NIVEL DA COLUNA
						
						//escolher uma linha onde pode começar
						randomNumber=Math.random();
						randomLinha= (int) (randomNumber*(size-(word.length()-1))); //MAS A PALAVRA TEM DE COMEÇAR NUMA LINHA ENTRE 0 E <TAMANHO DA MATRIZ - TAMANHO DA PALAVRA>
						
						if(randomLinha<0) {
							break;
						}
						
						overwritten = false;
						for(int i=randomLinha; i<randomLinha+word.length(); i++) {
							if(m[i][randomColuna] != 0){
								overwritten=true;
							}
						}
						
						if(!overwritten) {
							int pos=0;
							for(int i=randomLinha; i<randomLinha+word.length(); i++) {
								m[i][randomColuna]=word.charAt(pos);
								pos++;
							}
							wrote=true;
						}
						break;
					case 5: //SENTIDO: DIAGONAL CIMA ESQUEDA
						//escolha da coluna
						randomNumber=Math.random();
						randomColuna= (int) (randomNumber*(size-word.length())+word.length());
						
						//escolha da linha
						randomNumber=Math.random();
						randomLinha= (int) (randomNumber*(size-word.length()) + word.length());
						
						int count=0;
						overwritten = false;
						for(int i=randomLinha; i>randomLinha-word.length(); i--) {
							if(m[i][randomColuna-count] != 0){
								overwritten=true;
							}
							count++;
						}
						
						if(!overwritten) {
							int pos=0;
							for(int i=randomLinha; i>randomLinha-word.length(); i--) {
								m[i][randomColuna-pos]=word.charAt(pos);
								pos++;
							}
							wrote=true;
						}
						break;
					case 6: //SENTIDO: DIAGONAL BAIXO ESQUEDA
						//escolher a coluna em que começa
						randomNumber=Math.random();
						randomColuna= (int) ((randomNumber*(size-word.length()))+word.length());
						
						//escolher uma linha onde pode começar
						randomNumber=Math.random();
						randomLinha= (int) (randomNumber*(size-(word.length()-1)));
						
						
						if(randomLinha<0 || randomColuna>size) {
							break;
						}
						
						count=0;
						overwritten = false;
						for(int i=randomLinha; i<randomLinha+word.length(); i++) {
							if(m[i][randomColuna-count] != 0){
								overwritten=true;
							}
							count++;
						}
						
						if(!overwritten) {
							int pos=0;
							for(int i=randomLinha; i<randomLinha+word.length(); i++) {
								m[i][randomColuna-pos]=word.charAt(pos);
								pos++;
							}
							wrote=true;
						}
						
						
						break;
					case 7: //SENTIDO: DIAGONAL BAIXO DIREITA
						//escolher a coluna em que começa
						randomNumber=Math.random();
						randomColuna= (int) (randomNumber*(size-(word.length()-1)));
						
						//escolher uma linha onde pode começar
						randomNumber=Math.random();
						randomLinha= (int) (randomNumber*(size-(word.length()-1)));
						
						count=0;
						overwritten = false;
						for(int i=randomLinha; i<randomLinha+word.length(); i++) {
							if(m[i][randomColuna+count] != 0){
								overwritten=true;
							}
							count++;
						}
						if(!overwritten) {
							int pos=0;
							for(int i=randomLinha; i<randomLinha+word.length(); i++) {
								m[i][randomColuna+pos]=word.charAt(pos);
								pos++;
							}
							wrote=true;
						}
						
						break;
					case 8: //SENTIDO: DIAGONAL CIMA DIREITA
						//escolher uma linha onde pode começar
						randomNumber=Math.random();
						randomLinha= (int) (randomNumber*(size-word.length()) + word.length());
						
						//escolher a coluna em que começa
						randomNumber=Math.random();
						randomColuna= (int) (randomNumber*(size-(word.length()-1)));
						
						count=0;
						overwritten = false;
						for(int i=randomLinha; i>randomLinha-word.length(); i--) {
							if(m[i][randomColuna+count] != 0){
								overwritten=true;
							}
							count++;
						}
						
						if(!overwritten) {
							int pos=0;
							for(int i=randomLinha; i>randomLinha-word.length(); i--) {
								m[i][randomColuna+pos]=word.charAt(pos);
								pos++;
							}
							wrote=true;
						}
						
						break;
					default: break;
				}
			}

			wrote=false;
		}
		/*
			*
			*
			* CÓDIGO QUE PREENCHE O RESTO DA MATRIZ COM LETRAS ALEATÓRIAS
			*
			*
		*/
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				if (m[y][x] == 0) {
					Random r = new Random();
					char c = (char) (r.nextInt(26) + 'A'); // ESCOLHE ALEATORIAMENTE UMA LETRA MAISCULA PARA PREENCHER A POSIÇÃO DA MATRIZ
					m[y][x] = c;
				}
			}
		}
		
		/*
			*
			*
			* MOSTRA TODA A TABELA DA SOPA DE LETRAS
			*
			*
		*/
		int counter=0;
		for (char[] word : m) {
			counter++;
			if(counter<=size) {
				System.out.println(word);
			}
		}
		
		/*
			*
			*
			* MOSTRA TODAS AS PALAVRAS COM A FORMATAÇÃO ORIGINAL
			*
			*
		*/
		System.out.println(stringPalavras.toLowerCase());

		/*
			*
			*
			* GUARDAR A SOPA DE LETRAS, BEM COMO AS PALAVRAS NUM FICHEIRO (SE O UTILIZADOR ASSIM OPTAR)
			*
			*
		*/
		if(saveFile!=null){
			try {
	            FileWriter writer = new FileWriter(saveFile, false);
	            counter=0;
	    		for (char[] word : m) {
	    			counter++;
	    			if(counter<=size) {
	    				writer.write(word);
	    				writer.write("\r\n");
	    			}
	    		}
	    		writer.write(stringPalavras.toLowerCase());
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		/*
			*
			*
			* FIM DO FICHEIRO
			*
			*
		*/
	}
}