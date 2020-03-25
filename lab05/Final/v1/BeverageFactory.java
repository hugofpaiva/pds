public class BeverageFactory {
	// FACTORY DAS BEBIDAS; SERVE COMO INTERMEDIÁRIO PARA DECIDIR QUAL A BEBIDA A SER CRIADA
	public static Commodity createBeverage(Temperature temperatura) {
		Commodity ret = null;
		if(temperatura == Temperature.COLD) {
			ret = new FruitJuice();
		}
		else if (temperatura == Temperature.WARM) {
			ret = new Milk();
		}
		return ret;
	}
}
