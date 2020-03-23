package LAB5;

public class BeverageFactory {
	public static Commodity createBeverage(Temperature t) {
		Commodity c=null;
		
		if(t==Temperature.COLD) {
			c=new FruitJuice();
		}else{
			c=new Milk();
		}
		
		return c;
	}
}
