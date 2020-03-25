package lab05.v3;

import java.util.List;

public class Movie {
	private String title;
	private int year;
	private Person director;
	private Person writer;
	private String series;
	private List<Person> cast;
	private List<Place> locations;
	private List<String> languages;
	private List<String> genres;
	private boolean isTelevision;
	private boolean isNetflix;
	private boolean isIndependent;
	
	
	public void setTitle(String movieTitle) {
		this.title = movieTitle;
	}
	
	public void setYear(int movieYear) {
		this.year = movieYear;
	}
	
	public void setDirector(Person movieDirector) {
		this.director  = movieDirector;
	}
	
	public void setWriter(Person movieWriter) {
		this.writer  = movieWriter;
	}
	
	
	public void setSeries(String movieSeries) {
		this.series = movieSeries;
	}
	
	public void setCast(List<Person> movieCast) {
		this.cast = movieCast;
	}
	
	public void setLocations(List<Place> movieLocations) {
		this.locations = movieLocations;
	}
	
	public void setLanguages(List<String> movieLanguages) {
		this.languages = movieLanguages;
	}
	
	public void setTelevision(boolean television) {
		this.isTelevision = television;
	}
	
	public void setNetflix(boolean netflix) {
		this.isNetflix = netflix;
	}
	
	public void setIndependent(boolean independent) {
		this.isIndependent = independent;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", director=" + director + ", writer=" + writer
				+ ", series=" + series + ", cast=" + cast + ", locations=" + locations + ", languages=" + languages
				+ ", genres=" + genres + ", isTelevision=" + isTelevision + ", isNetflix=" + isNetflix
				+ ", isIndependent=" + isIndependent + "]";
	}
	
	
	
}
