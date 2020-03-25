public class exe2 {

	public static void main(String[] args) {
		// REFEIÇÃO DO CRASTRO
		LunchBuilder lunch = new CrastoLunchBuilder();
		LunchDirector mealDirector = new LunchDirector(lunch);
		mealDirector.constructMeal();
		Lunch meal = mealDirector.getMeal();
		System.out.println("Ana's meal is: " + meal);

		// REFEIÇÃO DO SNACK
		mealDirector = new LunchDirector(new SnackLunchBuilder());
		mealDirector.constructMeal();
		meal = mealDirector.getMeal();
		System.out.println("Rui's meal is: " + meal);

		// REFEIÇÃO DA CANTINA
		mealDirector = new LunchDirector(new CentralCantineLunchBuilder());
		mealDirector.constructMeal();
		meal = mealDirector.getMeal();
		System.out.println("My meal is: " + meal);
	}

}
