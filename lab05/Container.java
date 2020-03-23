public abstract class Container { 
    protected Commodity commodity;
    public boolean placeCommodity(Commodity c){ 
        this.commodity = c;
        return true;
    } 
}