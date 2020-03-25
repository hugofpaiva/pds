package lab05.v2;

public class CentralCantineLunchBuilder implements LunchBuilder {
	Lunch l = new Lunch();

	public void buildDrink() {
		l.setDrink("Água");

	}

	public void buildMainCourse() {
		l.setMainCourse("Grelhada mista");

	}

	public void buildSide() {
		l.setSide("Queijo fresco");

	}

	public Lunch getMeal() {
		return l;
	}

}
