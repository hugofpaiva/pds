public class ContainerFactory {
	// FACTORY DOS CONTAINERS; SERVE COMO INTERMEDIÁRIO PARA DECIDIR QUAL O CONTAINER A SER USADO PARA ARMAZENAR UMA CERTA COMIDA
	public static Container createContainerFor(Commodity x) {
		State estado = x.getState();
		Temperature temperatura = x.getTemperature();
		Container ret = null;

		if (estado == State.Liquid) {
			if (temperatura == Temperature.WARM)
				ret = new PlasticBottle();
			else if (temperatura == Temperature.COLD)
				ret = new TermicBottle();

		} else if (estado == State.Solid)
			if (temperatura == Temperature.WARM)
				ret = new PlasticBag();
			else if (temperatura == Temperature.COLD)
				ret = new Tupperware();
		return ret;
	}
}
