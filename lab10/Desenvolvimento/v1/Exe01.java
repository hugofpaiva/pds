import java.util.concurrent.TimeUnit;

public class Exe01 {
	public static void main(String[] args) throws InterruptedException {
		
		// cinco produtos
		Product p1 = new Product("Carro do James Bond", 50000);
		Product p2 = new Product("Primeiro computador do mundo", 10000);
		Product p3 = new Product("iPhone 2G", 22500);
		Product p4 = new Product("Terreno 1000m2", 70000);
		Product p5 = new Product("Relógio de Quartzo minado na lua", 2000);
		
		// tres clientes
		Client c1 = new Client("Joaquim");
		Client c2 = new Client("Martim");
		Client c3 = new Client("Joaquina");
		
		// um manager
		Manager m1 = new Manager("O Grande");
		
		// adiciona os produtos ao manager
		m1.addProduct(p1);
		m1.addProduct(p2);
		m1.addProduct(p3);
		m1.addProduct(p4);
		m1.addProduct(p5);
		
		// o segundo parâmetro indica quantos segundos deve durar a licitação
		m1.startLeilao(p1, 3);
		m1.startLeilao(p3, 3);
		m1.startLeilao(p4, 3);
		m1.startLeilao(p5, 3);
		
		p1.addObserver(c1);
		c1.leiloar(p1, 50001);
		
		TimeUnit.SECONDS.sleep(1);
		p2.addObserver(c3);
		c3.leiloar(p2, 10001); // não pode funcionar porque o estado do produto nunca chegou a ser leiloado
		
		p3.addObserver(c3);
		c3.leiloar(p3, 22555);
		
		TimeUnit.SECONDS.sleep(1);
		p4.addObserver(c1);
		c1.leiloar(p4, 70001);
	
		p5.addObserver(c2);
		c2.leiloar(p5, 20001);
		
		TimeUnit.SECONDS.sleep(1);
		p1.addObserver(c2);
		c2.leiloar(p1, 50002); 
		
		TimeUnit.SECONDS.sleep(2); // não deve mostrar mensagem porque passaram mais de 3 segundos
		p1.addObserver(c2);
		c2.leiloar(p1, 50003); 
	}
}
