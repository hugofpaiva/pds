package LAB5;

public class MeatFactory {

	public static Commodity createMeat(Temperature t) {
		Commodity c = null;
		if(t==Temperature.COLD) {
			c=new Tuna();
		}else {
			c=new Pork();
		}
		return c;
	}
}
