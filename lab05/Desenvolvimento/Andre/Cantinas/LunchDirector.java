package LAB5.v2;

public class LunchDirector {
	private LunchBuilder general;
	public LunchDirector(LunchBuilder lunch) {
		this.general=lunch;
	}
	
	public void constructMeal() {
		this.general.buildDrink();
		this.general.buildMainCourse();
		this.general.buildSide();
	}

	public Lunch getMeal() {
		return this.general.getMeal();
	}
	
}
