public class FruitJuice implements Commodity{
	// CARACTERISTICAS DO ALIMENTO
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
		return "FruitJuice [fruit="+FruitName +" Temperatura()=" + temperatura + ", State()=" + estado + "]";
	}

}