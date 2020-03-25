public class Lunch {
	private String drink;
    private String mainCourse;
    private String side;

    // MÉTODO QUE DEFINE O VALOR DA BEBIDA
    protected void setDrink(String drink){
        this.drink = drink;
    }

    // MÉTODO QUE DEFINE O VALOR DO PRATO PRINCIPAL
    protected void setMainCourse(String mainCourse){
        this.mainCourse = mainCourse;
    }

    // MÉTODO QUE DEFINE O VALOR DO ACOMPANHAMENTO
    protected void setSide(String side){
        this.side = side;
    }

    @Override
    public String toString(){
        return "[ drink: "+ drink + ", main course: " + mainCourse + ", side: " + side + " ]";
    }


}
