package lab11.Final.v1;

import java.util.Comparator;
import java.util.Scanner;

public class Exe01 {
	public static void main(String[] args){
		Telemovel t1 = new Telemovel("SmartPhor Two", "SnapLagart 3", 1099.00, 12000, "Samsung 12MP");
		Telemovel t2 = new Telemovel("iCall", "C12", 6969.00, 2000, "iCall 12MP");
		Telemovel t3 = new Telemovel("Nukia S", "SnapLagart 2", 10.00, 12000, "Samsung 12MP");
		Telemovel t4 = new Telemovel("Sangsunga dez", "Exynos 1", 900.00, 12000, "Samsung 12MP");
		Telemovel t5 = new Telemovel("Hu Ha Hei", "Kiriri", 1099.00, 12000, "Leica 122MP");
		
		Telemovel[] arrayT = {t1,t2,t3,t4,t5};
		
		Revista gsm = new Revista(arrayT);
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("\tOrdenar por\n");
        System.out.println("1) Processador");
        System.out.println("2) Preço");
        System.out.println("3) Memória");
        System.out.println("4) Camara");
        System.out.println("5) Nome");
        int ord = sc.nextInt();
        
        System.out.printf("\tCom o algoritmo\n");
        System.out.println("1) QuickSort");
        System.out.println("2) MergeSort");
        System.out.println("3) BubbleSort");
        int alg = sc.nextInt();
        
        System.out.printf("\tOrdem Ascendente ou Descendente\n");
        System.out.println("1) Ascendente");
        System.out.println("2) Descentente");
        int ordAscDesc = sc.nextInt();
        
        Comparator comp=null;
        if(ord==1) {
        	if(ordAscDesc==1) {
        		comp=new processadorCompAsc();
        	}else {
        		comp=new processadorCompDesc();
        	}
        }else if(ord==2) {
        	if(ordAscDesc==1) {
        		comp=new precoCompAsc();
        	}else {
        		comp=new precoCompDesc();
        	}
        }else if(ord==3) {
        	if(ordAscDesc==1) {
        		comp=new memoriaCompAsc();
        	}else {
        		comp=new memoriaCompDesc();
        	}
        }else if(ord==4) {
        	if(ordAscDesc==1) {
        		comp=new camaraCompAsc();
        	}else {
        		comp=new camaraCompDesc();
        	}
        }else if(ord==5) {
        	if(ordAscDesc==1) {
        		comp=new nomeCompAsc();
        	}else {
        		comp=new nomeCompDesc();
        	}
        }else {
        	System.err.println("Nenhuma opção encontrada.");
        }
        
        
        SortInterface sortAlg=null;
        if(alg==1) {
        	sortAlg=new QuickSort(arrayT, comp);
        }else if(alg==2) {
        	sortAlg=new MergeSort(arrayT, comp);
        }else if(alg==3) {
        	sortAlg=new BubbleSort(arrayT, comp);
        }else {
        	System.err.println("Nenhuma opção encontrada.");
        }
        
        gsm.setSortAlgorithm(sortAlg);
        gsm.sort();
        gsm.read();
        
	}
	
	static class camaraCompAsc implements Comparator<Telemovel> {
        @Override
        public int compare(Telemovel a, Telemovel b) {
        	return a.getCamara().compareToIgnoreCase(b.getCamara());
        }
    }
	
	static class camaraCompDesc implements Comparator<Telemovel> {
        @Override
        public int compare(Telemovel a, Telemovel b) {
        	return -a.getCamara().compareToIgnoreCase(b.getCamara());
        }
    }

    static class precoCompAsc implements Comparator<Telemovel> {
        @Override
        public int compare(Telemovel a, Telemovel b) {
            return a.getPreco() > b.getPreco() ? 1 : a.getPreco() == b.getPreco() ? 0 : -1;
        }
    }
    
    static class precoCompDesc implements Comparator<Telemovel> {
        @Override
        public int compare(Telemovel a, Telemovel b) {
            return a.getPreco() < b.getPreco() ? -1 : a.getPreco() == b.getPreco() ? 0 : 1;
        }
    }
    
    static class memoriaCompAsc implements Comparator<Telemovel> {
        @Override
        public int compare(Telemovel a, Telemovel b) {
            return a.getMemoria() > b.getMemoria() ? 1 : a.getMemoria() == b.getMemoria() ? 0 : -1;
        }
    }
    
    static class memoriaCompDesc implements Comparator<Telemovel> {
        @Override
        public int compare(Telemovel a, Telemovel b) {
            return a.getMemoria()< b.getMemoria() ? -1 : a.getMemoria() == b.getMemoria() ? 0 : 1;
        }
    }
    
    static class nomeCompAsc implements Comparator<Telemovel> {
        @Override
        public int compare(Telemovel a, Telemovel b) {
            return a.getNome().compareToIgnoreCase(b.getNome());
        }
    }
    
    static class nomeCompDesc implements Comparator<Telemovel> {
        @Override
        public int compare(Telemovel a, Telemovel b) {
            return - a.getNome().compareToIgnoreCase(b.getNome());
        }
    }
    
    static class processadorCompAsc implements Comparator<Telemovel> {
        @Override
        public int compare(Telemovel a, Telemovel b) {
            return a.getProcessador().compareToIgnoreCase(b.getProcessador());
        }
    }
    
    static class processadorCompDesc implements Comparator<Telemovel> {
        @Override
        public int compare(Telemovel a, Telemovel b) {
            return - a.getProcessador().compareToIgnoreCase(b.getProcessador());
        }
    }
}
