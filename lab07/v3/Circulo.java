public class Circulo extends Figure{
	private String property;
	
	public Circulo(String property) {
		this.property = property;
	}
	
	//Impressão da propriedade
	public String print() {
		return "Circulo " + property;
	}

}
