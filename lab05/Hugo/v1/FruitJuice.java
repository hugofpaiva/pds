package lab05.v1;

public class FruitJuice implements Commodity{
    private State estado = State.Liquid;
    private Temperature temperatura = Temperature.COLD;
    private String FruitName = "Orange";
    
    public Temperature getTemperature() {
		return temperatura;
	}
	
	public State getState() {
		return estado;
	}
    
	public String getFruitName() {
		return FruitName;
	}

	public String toString() {
		return "commodity=FruitJuice [fruit=+"+FruitName +"Temperatura()=" + temperatura + ", State()=" + estado + "]";
	}

}