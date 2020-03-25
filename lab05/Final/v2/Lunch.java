public class Lunch {
	private String drink;
    private String mainCourse;
    private String side;

    protected void setDrink(String drink){
        this.drink = drink;
    }

    protected void setMainCourse(String mainCourse){
        this.mainCourse = mainCourse;
    }

    protected void setSide(String side){
        this.side = side;
    }


    @Override
    public String toString(){
        return "[ drink: "+ drink + ", main course: " + mainCourse + ", side: " + side + " ]";
    }


}
