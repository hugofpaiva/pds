package LAB5;

public class Tuna implements Commodity{
	private State state = State.Solid;
	private Temperature temperature = Temperature.COLD;
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
		return "Tuna [Temperature()=" + temperature + ", State()=" + state + "]";
	}

}
