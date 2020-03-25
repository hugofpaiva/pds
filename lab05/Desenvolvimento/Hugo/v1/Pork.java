public class Pork implements Commodity{
    private State estado = State.Solid;
    private Temperature temperatura = Temperature.WARM;
    
    
	public Temperature getTemperature() {
		return temperatura;
	}

	public State getState() {
		return estado;
	}
	
	public String toString() {
		return "Pork [Temperatura()=" + temperatura + ", State()=" + estado + "]";
	}
    

}