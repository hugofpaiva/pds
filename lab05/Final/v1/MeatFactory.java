public class MeatFactory {
	// FACTORY DAS BEBIDAS; SERVE COMO INTERMEDIÁRIO PARA DECIDIR QUAL A COMIDA A SER CRIADA
	public static Commodity createMeat(Temperature temperatura) {
		Commodity ret = null;
		if(temperatura == Temperature.COLD) {
			ret = new Tuna();
		}
		else if (temperatura == Temperature.WARM) {
			ret = new Pork();
		}
		return ret;
	}
}
