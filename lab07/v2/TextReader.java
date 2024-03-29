import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TextReader implements FileInterface{
	private String paragraphs[]= new String[5];
	private int current_index=0;

	/*
		 *
		 * CARREGA OS DADOS NO VETOR PARAGRAPHS[] USANDO UM DELIMITADOR NO SCANNER (\R\N)
	 	 * O VETOR PARAGRAPHS É DINAMICAMENTE AUMENTADO À MEDIDA QUE SE VÃO ADICIONANDO PARÁGRAFOS
	 	 * ISTO PORQUE É MAIS FÁCIL TRABALHAR COM ARRAYS E COM O ÍNDICE DO PARAGRAFO QUE ESTÁ A SER LIDO NESTE MOMENTO
		 *
	 */
	public TextReader(String filename) {
		try {
	      	File myObj = new File(filename);
	      	Scanner myReader = new Scanner(myObj).useDelimiter("[\r\n]");
	      	int counter=0;
	      	while (myReader.hasNextLine()) {
	    	  	String paragraph = myReader.next();
	    	  	paragraphs[counter]=paragraph;
	    	  	counter++;
	    	  	if(counter==paragraphs.length) {
	    		  	extend();
		  	}
	    	  
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}

	@Override
	public boolean hasNext() {
		if(current_index<paragraphs.length)
			return true;
		else
			return false;
	}

	@Override
	public String next() {
		if(hasNext()) {
			return paragraphs[current_index++];
		}else {
			return null;
		}
	}
	
	private void extend() {
		this.paragraphs = Arrays.copyOf(paragraphs, paragraphs.length + 5);
	}
}
