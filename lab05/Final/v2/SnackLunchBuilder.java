public class SnackLunchBuilder implements LunchBuilder {
	Lunch l = new Lunch();

	// DEFINIR A BEBIDA
	public void buildDrink() {
		l.setDrink("Sumo");
	}

	// DEFINIR O PRATO PRINCIPAL
	public void buildMainCourse() {
		l.setMainCourse("Pão com Panado");
	}

	// DEFINIR O ACOMPANHAMENTO
	public void buildSide() {
		l.setSide("Rissol");
	}

	public Lunch getMeal() {
		return l;
	}

}
