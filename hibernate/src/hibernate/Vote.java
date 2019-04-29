package hibernate;

public class Vote {

private int vid;
private String pname;
private Voter voter;
public Voter getVoter() {
	return voter;
}
public void setVoter(Voter voter) {
	this.voter = voter;
}
public int getVid() {
	return vid;
}
public void setVid(int vtid) {
	this.vid = vtid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}

}
