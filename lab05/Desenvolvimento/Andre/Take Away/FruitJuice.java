package LAB5;

public class FruitJuice implements Commodity{
    private String other = "Laranja";
    private State state = State.Liquid;
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
		return "FruitJuice [Temperature()=" + temperature + ", State()=" + state + "]";
	}
    
}