// INTERFACE QUE INDICA QUAIS OS MÉTODOS QUE OS ALIMENTOS TÊM DE TER
public interface Commodity {
    public Temperature getTemperature(); 
    public State getState();
    public String toString();
}
