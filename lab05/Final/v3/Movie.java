import java.util.List;

public class Movie {
	private final String title;
	private final int year;
	private final Person director;
	private final Person writer;
	private final List<Person> cast;
	private final List<Place> locations;
	private final List<String> languages;
	private final List<String> genres;
	private final boolean isTelevision;
	private final boolean isNetflix;
	private final boolean isIndependent;

	// O CLASS BUILDER CRIA UM OBJETO COMPLEXO, À SEMELHANCE DO MOVIE, USANDO MÉTODOS MAIS SIMPLES E USANDO UMA ABORDAGEM PASSO A PASSO.
	public static class Builder{
		private final String title;
		private final int year;
		private Person director=null;
		private Person writer=null;
		private List<Person> cast=null;
		private List<Place> locations=null;
		private List<String> languages=null;
		private List<String> genres=null;
		private boolean isTelevision;
		private boolean isNetflix;
		private boolean isIndependent;


		public Builder(String title, int year) {
			this.title=title;
			this.year=year;
		}

		// OS PRÓXIMOS MÉTODOS SÃO USADOS COMO PASSOS NA CRIAÇÃO DO FILME FINAL
		public Builder Director(Person director) {
			this.director = director;
			return this;
		}

		public Builder Writer(Person writer) {
			this.writer = writer;
			return this;
		}

		public Builder Cast(List<Person> cast) {
			this.cast = cast;
			return this;
		}

		public Builder Locations(List<Place> locations) {
			this.locations = locations;
			return this;
		}

		public Builder Languages(List<String> languages) {
			this.languages = languages;
			return this;
		}

		public Builder Genres(List<String> genres) {
			this.genres = genres;
			return this;
		}

		public Builder Television(boolean isTelevision) {
			this.isTelevision = isTelevision;
			return this;
		}

		public Builder Netflix(boolean isNetflix) {
			this.isNetflix = isNetflix;
			return this;
		}

		public Builder Independent(boolean isIndependent) {
			this.isIndependent = isIndependent;
			return this;
		}
		
		public Movie buildMovie() {
			return new Movie(this);
		}
		
	}

	// CONSTRUTOR DO MOVIE, QUE RECEBE O BUILDER E ASSOCIA OS PARAMETROS DO MOVIE COM OS PARAMETROS DO BUILDER
	private Movie(Builder b) {
		this.title=b.title;
		this.year=b.year;
		this.director=b.director;
		this.writer=b.writer;
		this.cast=b.cast;
		this.locations=b.locations;
		this.languages=b.languages;
		this.genres=b.genres;
		this.isTelevision=b.isTelevision;
		this.isNetflix=b.isNetflix;
		this.isIndependent=b.isIndependent;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", director=" + director + ", writer=" + writer + ", cast="
				+ cast + ", locations=" + locations + ", languages=" + languages + ", genres=" + genres
				+ ", isTelevision=" + isTelevision + ", isNetflix=" + isNetflix + ", isIndependent=" + isIndependent
				+ "]";
	}
}