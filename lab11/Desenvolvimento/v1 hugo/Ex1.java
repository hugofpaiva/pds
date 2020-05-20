package lab11.v1;

import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		Phone p = new Phone("iPhone 11 Pro", "A11 Bionic", 1100.99, 6, "Triple");
		Phone p1 = new Phone("iPhone 12 Pro", "A12 Bionic", 1200.99, 8, "Quad");
		Phone p2 = new Phone("iPhone 13 Pro", "A13 Bionic", 1300.99, 10, "Penta");
		Phone p3 = new Phone("iPhone 14 Pro", "A14 Bionic", 1400.99, 12, "Hexa");
		Phone p4 = new Phone("iPhone 15 Pro", "A15 Bionic", 1500.99, 14, "Octa");
		Phone p5 = new Phone("iPhone 16 Pro", "A16 Bionic", 1600.99, 16, "Ten");
		
		Revista c = new Revista();
		c.add(p);
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);
	
		Scanner sc = new Scanner(System.in);
        System.out.printf("\t\tOrdenar por\n");
        System.out.println("1) Nome");
        System.out.println("2) Processador");
        System.out.println("3) Preço");
        System.out.println("4) Memória");
        System.out.println("5) Camara");
        int ord = sc.nextInt();

        System.out.printf("\t\tCom o algoritmo\n");
        System.out.println("1) QuickSort");
        System.out.println("2) MergeSort");
        System.out.println("3) HeapSort");
        int alg = sc.nextInt();
        
        
		System.out.println("Result: " + c.order());
		
		c.setStrategy(new Algoritm2());
		System.out.println("Result: " + c.order());
		
		c.setStrategy(new Algoritm3());
		System.out.println("Result: " + c.order());
	}
}
