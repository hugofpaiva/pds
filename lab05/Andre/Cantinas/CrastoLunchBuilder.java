package LAB5.v2;

public class CrastoLunchBuilder implements LunchBuilder{
	private Lunch lunch = new Lunch();

	@Override
	public void buildDrink() {
		lunch.setDrink("Vinho Tinto");
		
	}

	@Override
	public void buildMainCourse() {
		lunch.setMainCourse("Bacalhau à lagareiro");
		
	}

	@Override
	public void buildSide() {
		lunch.setSide("Broa");
		
	}

	@Override
	public Lunch getMeal() {
		return lunch;
	}
}
