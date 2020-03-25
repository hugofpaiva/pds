public class CentralCantineLunchBuilder implements LunchBuilder {
	Lunch l = new Lunch();

	// DEFINIR A BEBIDA
	public void buildDrink() {
		l.setDrink("Água");
	}

	// DEFINIR O PRATO PRINCIPAL
	public void buildMainCourse() {
		l.setMainCourse("Grelhada mista");
	}

	// DEFINIR O ACOMPANHAMENTO
	public void buildSide() {
		l.setSide("Queijo fresco");
	}

	public Lunch getMeal() {
		return l;
	}

}
