package lab05.v1;

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
		return "commodity=Pork [Temperatura()=" + temperatura + ", State()=" + estado + "]";
	}
    

}