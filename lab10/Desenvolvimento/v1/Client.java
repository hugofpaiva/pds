public class Client implements Observer{
	String name;
	public Client(String name) {
		this.name=name;
	}
	@Override
	public void update(String s) {
		System.out.println(s);
	}
	@Override
	public String getType() {
		return "Client";
	}
	
	public String getName() {
		return name;
	}
	
	public void leiloar(Product p, double v) {
		if(p!=null) {
			p.receberLicitacao(v, this);
		}else {
			System.out.println("Não podes leiloar um produto que não existe!");
		}
	}
}
