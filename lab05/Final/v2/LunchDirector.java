public class LunchDirector {
	private LunchBuilder lb;

	// CONSTRUTOR
	public LunchDirector(LunchBuilder lb) {
		this.lb=lb;
	}

	// CHAMA OS MÉTODOS DO BUILDER
	public void constructMeal() {
		lb.buildDrink();
		lb.buildMainCourse();
		lb.buildSide();
	}
	
	public Lunch getMeal() {
		return lb.getMeal();	
	}

}
