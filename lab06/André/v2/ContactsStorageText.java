package LAB6.v2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsStorageText implements ContactsStorageInterface{
	private String file;
	public ContactsStorageText(String filename) {
		this.file=filename;
	}

	@Override
	public List<Contact> loadContacts() {
		List<Contact> facebook = new ArrayList<>();
		try {
	      File myObj = new File(this.file);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String line = myReader.nextLine();
	        String[] a = line.split(",");
		    Contact c = new Contact(a[0], Integer.valueOf(a[1]));
		    facebook.add(c);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		return facebook;
	}

	@Override
	public boolean saveContacts(List<Contact> list) {
		String texto="";
		int counter = 0;
		for(Contact x : list) {
			counter++;
			texto+=x.getNome() + "," + x.getNumero();
			if(counter<list.size()) {
				texto+="\n";
			}
		}
		try (PrintWriter out = new PrintWriter(file)) {
		    out.print(texto);
		}catch(FileNotFoundException e) {
			System.err.println("Ficheiro não pôde ser guardado");
		}
		return false;
	}

}
