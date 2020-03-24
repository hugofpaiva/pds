package LAB5.v3;

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
		private String title;
		private int year;
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

		public void setDirector(Person director) {
			this.director = director;
		}

		public void setWriter(Person writer) {
			this.writer = writer;
		}

		public void setCast(List<Person> cast) {
			this.cast = cast;
		}

		public void setLocations(List<Place> locations) {
			this.locations = locations;
		}

		public void setLanguages(List<String> languages) {
			this.languages = languages;
		}

		public void setGenres(List<String> genres) {
			this.genres = genres;
		}

		public void setTelevision(boolean isTelevision) {
			this.isTelevision = isTelevision;
		}

		public void setNetflix(boolean isNetflix) {
			this.isNetflix = isNetflix;
		}

		public void setIndependent(boolean isIndependent) {
			this.isIndependent = isIndependent;
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
}