public class Rectangulo extends Figure{
	private String property;
	
	public Rectangulo(String property) {
		this.property = property;
	}
	
	//Impressão da propriedade
	public String print() {
		return "Rectangulo " + property;
	}

}
