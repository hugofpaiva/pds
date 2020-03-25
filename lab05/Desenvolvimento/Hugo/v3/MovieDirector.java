public class MovieDirector {
	private MovieBuilder mb;
	
	public MovieDirector(MovieBuilder mb) {
		this.mb=mb;
	}

	public void MovieContent() {
		mb.buildTitle();
		mb.buildYear();
		mb.buildDirector();
		mb.buildWriter();
		mb.buildSeries();
		mb.buildCast();
		mb.buildLocations();
		mb.buildLanguages();
		mb.buildgenres();
		mb.buildTelevision();
		mb.buildNetflix();
		mb.buildIndependent();
	}
	
	public Movie getContent() {
		return mb.getMovie();	
	}

}

