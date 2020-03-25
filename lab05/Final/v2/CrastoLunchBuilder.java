public class CrastoLunchBuilder implements LunchBuilder{
	Lunch l = new Lunch();

	// DEFINIR A BEBIDA
	public void buildDrink() {
		l.setDrink("Vinho Tinto");
	}

	// DEFINIR O PRATO PRINCIPAL
	public void buildMainCourse() {
		l.setMainCourse("Bacalhau à lagareiro");
	}

	// DEFINIR O ACOMPANHAMENTO
	public void buildSide() {
		l.setSide("Broa");
	}

	public Lunch getMeal() {
		return l;
	}

}
