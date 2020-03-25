package LAB5;

public class Milk implements Commodity {
	private State state = State.Liquid;
	private Temperature temperature = Temperature.WARM;
	@Override
	public Temperature getTemperature() {
		// TODO Auto-generated method stub
		return temperature;
	}
	@Override
	public State getState() {
		// TODO Auto-generated method stub
		return state;
	}
	@Override
	public String toString() {
		return "Milk [Temperature()=" + temperature + ", State()=" + state + "]";
	}
}
