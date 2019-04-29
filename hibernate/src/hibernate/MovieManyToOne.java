package hibernate;

public class MovieManyToOne {
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	int movieId;
	String movieName;
	public ActorManyToOne getId() {
		return id;
	}
	public void setId(ActorManyToOne id) {
		this.id = id;
	}
	ActorManyToOne id;
	
}
