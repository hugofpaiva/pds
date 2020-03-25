public class Tuna implements Commodity {
	// CARACTERÍSTICAS DO ALIMENTO
	private State estado = State.Liquid;
	private Temperature temperatura = Temperature.COLD;
	//

	public Temperature getTemperature() {
		return temperatura;
	}

	public State getState() {
		return estado;
	}

	public String toString() {
		return "Tuna [Temperatura()=" + temperatura + ", State()=" + estado + "]";
	}

}