public abstract class Container { 
    protected Commodity commodity;

    // ARMAZENA NO CONTAINER UM ALIMENTO ESPECÍFICO
    public boolean placeCommodity(Commodity c){ 
        this.commodity = c;
        return true;
    } 
}