public class ContainerFactory {
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
