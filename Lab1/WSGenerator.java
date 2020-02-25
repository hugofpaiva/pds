package LAB1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class exe2 {
	static List<String> palavras=new ArrayList<String>();
	//dimenções
	static int size;
	static char m[][] = new char[50][50];
	public static void main(String[] args) {
		
		//leitura do ficheiro
		try {
			File file = new File("./src/LAB1/palavrasParaSopa.txt"); 
		    Scanner sc = new Scanner(file); 
		  
		    while (sc.hasNextLine()){
		    	String linha=sc.nextLine().trim();
		    	
		    	if(linha.contains(",") || linha.contains(";") || linha.contains(" ")) {
		    		String[] lista = linha.split("[,; ]");
		    		for(String s : lista)
		    			palavras.add(s);
		    		
		    	}else {
		    		palavras.add(linha);
		    	}
		  	}
		    sc.close();
		    size=12;
		}catch (IOException e) {
			System.out.println("O ficheiro nao existe");
			System.exit(0);
		}
		
		boolean wrote = false;
		for(String word : palavras) {
			while(!wrote){
				double randomInteger = Math.random();
				randomInteger = randomInteger * 8 + 1;
				int randomInt = (int) randomInteger;
				
				switch(randomInt) {
					case 1: 
						
						//escolher uma linha aleatoria
						double randomNumber=Math.random();
						int randomLinha= (int) (randomNumber*(size));
						
						//escolher a coluna em que começa
						randomNumber=Math.random();
						int randomColuna= (int) ((randomNumber*(size-word.length()))+word.length());
						
						if(randomColuna>=size) {
							break;
						}
						
						boolean overwritten = false;
						for(int i=randomColuna; i>randomColuna-word.length(); i--) {
							if(m[randomLinha][i] != 0){
								overwritten=true;
							}
						}
						
						if(!overwritten) {
							int pos=0;
							for(int i=randomColuna; i>randomColuna-word.length(); i--) {
								m[randomLinha][i]=word.charAt(pos);
								pos++;
							}
							wrote=true;
						}
						
						break;
					case 2: 
						//escolher uma linha aleatoria
						randomNumber=Math.random();
						randomLinha= (int) (randomNumber*(size));
						
						//escolher a coluna em que começa
						randomNumber=Math.random();
						randomColuna= (int) (randomNumber*(size-(word.length()-1))); // aqui é preciso ter cuidado com o tamanho da palavra para que não haja erros nos limites da matriz
						
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
					case 3: 
						//escolher uma coluna aleatoria
						randomNumber=Math.random();
						randomColuna= (int) (randomNumber*(size));
						
						//escolher uma linha onde pode começar
						randomNumber=Math.random();
						randomLinha= (int) (randomNumber*(size-word.length()) + word.length());
						
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
					case 4: 
						//escolher uma coluna aleatoria
						randomNumber=Math.random();
						randomColuna= (int) (randomNumber*(size));
						
						//escolher uma linha onde pode começar
						randomNumber=Math.random();
						randomLinha= (int) (randomNumber*(size-(word.length()-1)));
						
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
					case 5: 
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
					case 6: 
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
					case 7:
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
					case 8: 
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
		
		
		//GERAR O RESTO DAS LETRAS
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				if (m[y][x] == 0) {
					Random r = new Random();
					char c = (char) (r.nextInt(26) + 'A');
					m[y][x] = c;
				}
			}
		}
		
		//MOSTRAR TODA A TABELA
		for (char[] word : m) {
			System.out.println(word);
		}
		
		
	}
}
