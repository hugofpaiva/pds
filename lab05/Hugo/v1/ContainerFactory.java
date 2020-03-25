package lab05.v1;

import java.util.Random;

public class ContainerFactory {
	public static Container createContainerFor(Commodity x) {
		State estado = x.getState();
		Temperature temperatura = x.getTemperature();
		Container ret = null;
		if (estado == State.Liquid && temperatura == Temperature.WARM) {
			ret = new TermicBottle();

		} else if (estado == State.Liquid && temperatura == Temperature.COLD) {
			Random rd = new Random();
			Boolean choice = rd.nextBoolean();
			if (choice) {
				ret = new TermicBottle();
			} else {
				ret = new PlasticBottle();
			}
		} else if (estado == State.Solid && temperatura == Temperature.WARM) {
			ret = new Tupperware();
		} else if (estado == State.Solid && temperatura == Temperature.COLD) {
			Random rd = new Random();
			Boolean choice = rd.nextBoolean();
			if (choice) {
				ret = new Tupperware();
			} else {
				ret = new PlasticBag();

			}
		}
		return ret;
	}
}
