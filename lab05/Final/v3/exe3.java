public class exe3 {
    public static void main(String[] args) {
        Movie filme = new Movie.Builder("Titanic", 1997).Netflix(true).Independent(false).buildMovie();
        System.out.println(filme);
    }
}