public interface Commodity {
    public Temperature getTemperature(); 
    public State getState();
}
public enum State {
    Solid, Liquid; 
}
public enum Temperature {
    WARM, COLD;
}