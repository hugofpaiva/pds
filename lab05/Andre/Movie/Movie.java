import java.util.List;

public class Movie {
	private final String title;
	private int year;
	private final Person director;
	private final Person writer;
	private final List<Person> cast;
	private final List<Place> locations;
	private final List<String> languages;
	private final List<String> genres;
	private final boolean isTelevision;
	private final boolean isNetflix;
	private final boolean isIndependent;
	
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

		public Builder setDirector(Person director) {
			this.director = director;
			return this;
		}

		public Builder setWriter(Person writer) {
			this.writer = writer;
			return this;
		}

		public Builder setCast(List<Person> cast) {
			this.cast = cast;
			return this;
		}

		public Builder setLocations(List<Place> locations) {
			this.locations = locations;
			return this;
		}

		public Builder setLanguages(List<String> languages) {
			this.languages = languages;
			return this;
		}

		public Builder setGenres(List<String> genres) {
			this.genres = genres;
			return this;
		}

		public Builder setTelevision(boolean isTelevision) {
			this.isTelevision = isTelevision;
			return this;
		}

		public Builder setNetflix(boolean isNetflix) {
			this.isNetflix = isNetflix;
			return this;
		}

		public Builder setIndependent(boolean isIndependent) {
			this.isIndependent = isIndependent;
			return this;
		}
		
		public Movie buildMovie() {
			return new Movie(this);
		}
	}
	
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

	public java.lang.String toString() {
		return "Filme: " +
				"title='" + title + '\'' +
				", \nyear=" + year +
				", \ndirector=" + director +
				", \nwriter=" + writer +
				", \ncast=" + cast +
				", \nlocations=" + locations +
				", \nlanguages=" + languages +
				", \ngenres=" + genres +
				", \nisTelevision=" + isTelevision +
				", \nisNetflix=" + isNetflix +
				", \nisIndependent=" + isIndependent;
	}
}