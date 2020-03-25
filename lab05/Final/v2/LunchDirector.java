public class LunchDirector {
	private LunchBuilder lb;
	
	public LunchDirector(LunchBuilder lb) {
		this.lb=lb;
	}

	public void constructMeal() {
		lb.buildDrink();
		lb.buildMainCourse();
		lb.buildSide();
	}
	
	public Lunch getMeal() {
		return lb.getMeal();	
	}

}
