package lab05.v2;

public class CrastoLunchBuilder implements LunchBuilder{
	Lunch l = new Lunch();

	public void buildDrink() {
		l.setDrink("Vinho Tinto");

	}

	public void buildMainCourse() {
		l.setMainCourse("Bacalhau à lagareiro");

	}

	public void buildSide() {
		l.setSide("Broa");

	}

	public Lunch getMeal() {
		return l;
	}

}
