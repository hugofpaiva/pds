package LAB5;

public class ContainerFactory {
	public static Container createContainerFor(Commodity c) {
		Container cont = null;
		if(c.getState()==State.Liquid) {
			if(c.getTemperature()==Temperature.COLD) {
				cont=new PlasticBottle();
			}else {
				cont=new TermicBottle();
			}
		}else {
			if(c.getTemperature()==Temperature.COLD) {
				cont=new PlasticBag();
			}else {
				cont=new Tupperware();
			}
		}
		return cont;
	}
}
