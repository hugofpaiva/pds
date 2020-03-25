package LAB5;

public class Pork implements Commodity{
	private State state = State.Solid;
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
		return "Pork [Temperature()=" + temperature + ", State()=" + state + "]";
	}
}
