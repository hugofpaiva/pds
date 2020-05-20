package LAB11.v3;

import java.util.Scanner;

public class Exe03 {
	public static void main(String[] args) {
		Biblioteca Bert=new Biblioteca();
		
		Livro l1=new Livro("As crónicas do Hugo", "André Morais", 123456678, 2020);
		Livro l2=new Livro("Alquimia - O poder surpreendente das ideias absurdas", "Rory Sutherland", 325682356, 2020);
		Livro l3=new Livro("Rainhas portuguesas", "Discovery Channel", 482756381, 2020);
		Livro l4=new Livro("A arte de dizer caralh*", "Um tolo qualquer", 193057129, 2020);
		
		Bert.addLivro(l1);
		Bert.addLivro(l2);
		Bert.addLivro(l3);
		Bert.addLivro(l4);
		
		Bert.operacoes();
	}
}
