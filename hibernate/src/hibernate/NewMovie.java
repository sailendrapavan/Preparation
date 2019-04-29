package hibernate;

public class NewMovie {
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMovieTiming() {
		return movieTiming;
	}
	public void setMovieTiming(String movieTiming) {
		this.movieTiming = movieTiming;
	}
	private int sid;
	private String name;
	private String movieTiming;
}
