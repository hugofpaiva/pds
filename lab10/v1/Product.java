import java.util.ArrayList;
import java.util.Date;

enum State{
	stock, leilao, vendas
}

public class Product {
	int uid;
	String desc;
	double price;
	State state;
	ArrayList<Observer> participants;
	Date startTime;
	int maxTime=0;
	public Product(String desc, double price) {
		this.desc=desc;
		this.price=price;
		this.state=State.stock;
		participants=new ArrayList<>();
	}
	
	
	/* 
	 	* uma licitação a um dado produto é feita se o produto tiver o estado "leilao"
	 	* se a licitação for menor do que a maior licitação, o estado não for leilão, já tiver passado o tempo de licitação, ou se o Observer não for um "Client", a licitação não é feita
	 	* se o tempo de licitação já tiver acabado, então o seu estado passa a "vendas"
	 	* se a licitação for feita, então todos os  Observers são notificados
	*/
	public boolean receberLicitacao(double v, Observer o) {	
		Date currentTime = new Date();
		int segundos=0;
		if(startTime!=null) {
			segundos = (int)((currentTime.getTime() - startTime.getTime()) / 1000);
		}
		
		if(v<=price || this.state!=State.leilao || segundos > maxTime || o.getType()!="Client") {
			if(segundos > maxTime) {
				state=State.vendas;
			}
			return false;
		}else {
			price=v;
				System.out.println("Passaram-se " + segundos + " segundos.");
			notify(" Nova licitação com valor " + v + " feita por "+o.getName()+" ao produto "+this.desc);
			
		}
		return true;
	}
	
	public boolean addObserver(Observer o) {
		if(this.state==State.leilao) {
			participants.add(o);
			return true;
		}else {
			return false;
		}
		
	}
	
	// colocar o produto em leilão
	public void makeAlive(int mt) {
		this.state=State.leilao;
		startTime = new Date();
		maxTime=mt;
	}
	
	// notifica todos os Observers deste produto que o produto voltou a ser leiloado
	public void notify(String s) {
		for(Observer p : participants) {
			p.update("[" + p.getType() + " - " + p.getName() + "]" + s);
		}
	}
}
