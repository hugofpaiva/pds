public class init{
    public static void main(String[] args){
        Movie zerozerosete = new Movie.Builder("No time to die", 2020).setDirector(new Person()).setDirector(new Person()).setNetflix(true).buildMovie();

        System.out.println(zerozerosete);
    }
}