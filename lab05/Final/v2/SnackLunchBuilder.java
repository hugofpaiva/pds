public class SnackLunchBuilder implements LunchBuilder {
	Lunch l = new Lunch();

	public void buildDrink() {
		l.setDrink("Sumo");

	}

	public void buildMainCourse() {
		l.setMainCourse("Pão com Panado");

	}

	public void buildSide() {
		l.setSide("Rissol");

	}

	public Lunch getMeal() {
		return l;
	}

}
