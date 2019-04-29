package hibernate;


public class ActorManyToOne {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	private int id;
	private String actorName;

}
