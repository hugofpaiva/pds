public class Milk implements Commodity{
    private State estado = State.Liquid;
    private Temperature temperatura = Temperature.WARM;

	public Temperature getTemperature() {
		return temperatura;
	}
	
	public State getState() {
		return estado;
	}

	public String toString() {
		return "Milk [Temperatura()=" + temperatura + ", State()=" + estado + "]";
	}
	
	


}

