public class Quadrado extends Figure{
	private String property;
	
	public Quadrado(String property) {
		this.property = property;
	}
	
	//Impressão da propriedade
	public String print() {
		return "Quadrado " + property;
	}

}
